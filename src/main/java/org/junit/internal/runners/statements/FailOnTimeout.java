package org.junit.internal.runners.statements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.internal.management.ManagementFactory;
import org.junit.internal.management.ThreadMXBean;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;

public class FailOnTimeout extends Statement {
    private final Statement originalStatement;
    private final TimeUnit timeUnit;
    private final long timeout;
    private final boolean lookForStuckThread;

    /**
     * Returns a new builder for building an instance.
     *
     * @since 4.12
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Creates an instance wrapping the given statement with the given timeout in milliseconds.
     *
     * @param statement the statement to wrap
     * @param timeoutMillis the timeout in milliseconds
     * @deprecated use {@link #builder()} instead.
     */
    @Deprecated
    public FailOnTimeout(Statement statement, long timeoutMillis) {
        this(builder().withTimeout(timeoutMillis, TimeUnit.MILLISECONDS), statement);
    }

    private FailOnTimeout(Builder builder, Statement statement) {
        originalStatement = statement;
        timeout = builder.timeout;
        timeUnit = builder.unit;
        lookForStuckThread = builder.lookForStuckThread;
    }

    /**
     * Builder for {@link FailOnTimeout}.
     *
     * @since 4.12
     */
    public static class Builder {
        private boolean lookForStuckThread = false;
        private long timeout = 0;
        private TimeUnit unit = TimeUnit.SECONDS;

        private Builder() { }

        /**
         * Specifies the time to wait before timing out the test.
         *
         * <p>If this is not called, or is called with a {@code timeout} of
         * {@code 0}, the returned {@code Statement} will wait forever for the
         * test to complete, however the test will still launch from a separate
         * thread. This can be useful for disabling timeouts in environments
         * where they are dynamically set based on some property.
         *
         * @param timeout the maximum time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return {@code this} for method chaining.
         */
        public Builder withTimeout(long timeout, TimeUnit unit) {
            this.timeout = timeout;
            this.unit = unit;
            return this;
        }

        /**
         * Specifies whether to look for a stuck thread.  If a timeout occurs and this
         * feature is enabled, the test will look for a thread that appears to be stuck
         * and dump its backtrace.  This feature is experimental.  Behavior may change
         * after the 4.12 release in response to feedback.
         *
         * @param enable {@code true} to enable the feature
         * @return {@code this} for method chaining.
         */
        public Builder withLookingForStuckThread(boolean enable) {
            this.lookForStuckThread = enable;
            return this;
        }

        /**
         * Builds a {@link FailOnTimeout} instance using the values in this builder,
         * wrapping the given statement.
         *
         * @param statement statement to build
         */
        public FailOnTimeout build(Statement statement) {
            return new FailOnTimeout(this, statement);
        }
    }

    @Override
    public void evaluate() throws Throwable {
        CallableStatement callable = new CallableStatement();
        FutureTask<Throwable> task = new FutureTask<Throwable>(callable);
        ThreadGroup threadGroup = threadGroupForNewThread();
        Thread thread = new Thread(threadGroup, task, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        callable.awaitStarted();
        Throwable throwable = getResult(task, thread);
        if (throwable != null) {
            throw throwable;
        }
    }

    private ThreadGroup threadGroupForNewThread() {
        if (!lookForStuckThread) {
            return ManagementFactory.getThreadMXBean().getThreadInfo(
            Thread.currentThread().getId()).getThreadName().contains("Surefire")
            ? ManagementFactory.getThreadMXBean().getThreadInfo(
            Thread.currentThread().getId()).getThreadGroup() : null;
        }
        
        return null;
    }

    /**
     * Wait for the test task, returning the exception thrown by the test if the
     * test failed, an exception indicating a timeout if the test timed out, or
     * {@code null} if the test passed.
     */
    private Throwable getResult(FutureTask<Throwable> task, Thread thread) {
        try {
            if (timeout > 0) {
                return task.get(timeout, timeUnit);
            } else {
                return task.get();
            }
        } catch (InterruptedException e) {
            return e; // caller will re-throw; no need to call Thread.interrupt()
        } catch (ExecutionException e) {
            // test failed; have caller re-throw the exception thrown by the test
            e.fillInStackTrace();
            return e;
        } catch (TimeoutException e) {
            return createTimeoutException(thread);
        }
    }

    private Exception createTimeoutException(Thread thread) {
        final StackTraceElement[] stackTrace = thread.getStackTrace();
        return new TestTimedOutException(timeout, timeUnit, stackTrace);
    }

    /**
     * Retrieves the stack trace for a given thread.
     * @param thread The thread whose stack is to be retrieved.
     * @return The stack trace; returns a zero-length array if the thread has 
     * terminated or the stack cannot be retrieved for some other reason.
     */
    private StackTraceElement[] getStackTrace(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException e) {
            return new StackTraceElement[0];
        }
    }

    /**
     * Determines whether the test appears to be stuck in some thread other than
     * the "main thread" (the one created to run the test).  This feature is experimental.
     * Behavior may change after the 4.12 release in response to feedback.
     * @param mainThread The main thread created by {@code evaluate()}
     * @return The thread which appears to be causing the problem, if different from
     * {@code mainThread}, or {@code null} if the main thread appears to be the
     * problem or if the thread cannot be determined.  The return value is never equal 
     * to {@code mainThread}.
     */
    private Thread getStuckThread(Thread mainThread) {
        if (!lookForStuckThread) {
            return null;
        }
        
        long maxCpuTime = 0;
        Thread stuckThread = null;
        
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        if (!mxBean.isThreadCpuTimeSupported()) {
            return null;
        }
        for (Thread thread : getThreadsInGroup(mainThread.getThreadGroup())) {
            if (thread.getState() != Thread.State.TERMINATED) {
                // Poll two more times to work around a bug in Sun's
                // JRockit JVM, where calling getThreadCpuTime has a side
                // effect of updating the values returned by
                // getThreadAllocatedBytes, getThreadAllocatedBytes(long)
                // and isThreadCpuTimeSupported.
                //
                // See http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6440520
                //
                // This workaround is only enabled on JRockit JVM
                // (through a system property) as it has a performance
                // penalty on some JVMs.
                long threadCpuTime = getCpuTime(thread);
                if (threadCpuTime > maxCpuTime) {
                    maxCpuTime = threadCpuTime;
                    stuckThread = thread;
                }
            }
        }
        
        if (stuckThread != null && maxCpuTime > unit.toNanos(timeout)) {
            return stuckThread;
        } else {
            return null;
        }
    }

    /**
     * Returns all active threads belonging to a thread group.  
     * @param group The thread group.
     * @return The active threads in the thread group.  The result should be a
     * complete list of the active threads at some point in time.  Returns an empty list
     * if this cannot be determined, e.g. because new threads are being created at an
     * extremely fast rate.
     */
    private List<Thread> getThreadsInGroup(ThreadGroup group) {
        Thread[] threads = new Thread[group.activeCount() * 2];
        int numThreads = group.enumerate(threads, false);
        
        List<Thread> result = new java.util.ArrayList<Thread>(numThreads);
        for (Thread thread : threads) {
            if (thread != null) {
                result.add(thread);
            }
        }
        return result;
    }

    /**
     * Returns the CPU time used by a thread, if possible.
     * @param thr The thread to query.
     * @return The CPU time used by {@code thr}, or 0 if it cannot be determined.
     */
    private long cpuTime(Thread thr) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        if (mxBean.isThreadCpuTimeSupported()) {
            try {
                return mxBean.getThreadCpuTime(thr.getId());
            } catch (UnsupportedOperationException e) {
            }
        }
        return 0;
    }

    private class CallableStatement implements Callable<Throwable> {
        private final CountDownLatch startLatch = new CountDownLatch(1);

        public Throwable call() throws Exception {
            awaitStarted();
            try {
                final FutureTask<Throwable> task = new FutureTask<Throwable>(
                new Callable<Throwable>() {
                    public Throwable call() throws Exception {
                        try {
                            return null;
                        } finally {
                            // notify that the test is done
                            startLatch.countDown();
                        }
                    }
                });
                Thread taskThread = new Thread(threadGroupForNewThread(), task,
                "Time-limited test");
                taskThread.setDaemon(true);
                taskThread.start();
                return getResult(task, taskThread);
            } catch (Exception e) {
                return e;
            }
        }

        public void awaitStarted() throws InterruptedException {
            startLatch.await();
        }
    }
}
