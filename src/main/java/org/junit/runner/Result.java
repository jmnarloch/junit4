package org.junit.runner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * A <code>Result</code> collects and summarizes information from running multiple tests.
 * All tests are counted -- additional information is collected from tests that fail.
 *
 * @since 4.0
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final ObjectStreamField[] serialPersistentFields =
            ObjectStreamClass.lookup(SerializedForm.class).getFields();
    private final AtomicInteger count;
    private final AtomicInteger ignoreCount;
    private final AtomicInteger assumptionFailureCount;
    private final CopyOnWriteArrayList<Failure> failures;
    private final AtomicLong runTime;
    private final AtomicLong startTime;

    /** Only set during deserialization process. */
    private SerializedForm serializedForm;

    public Result() {
        
    }

    private Result(SerializedForm serializedForm) {
        
    }

    /**
     * Returns the number of tests run
     */
    public int getRunCount() {
        
    }

    /**
     * Returns the number of tests that failed during the run
     */
    public int getFailureCount() {
        
    }

    /**
     * Returns the number of milliseconds it took to run the entire suite to run
     */
    public long getRunTime() {
        
    }

    /**
     * Returns the {@link Failure}s describing tests that failed and the problems they encountered
     */
    public List<Failure> getFailures() {
        
    }

    /**
     * @return the number of tests ignored during the run
     */
    public int getIgnoreCount() {
        
    }

    /**
     * Returns the number of tests skipped because of an assumption failure
     *
     * @throws UnsupportedOperationException if the result was serialized in a version before JUnit 4.13
     * @since 4.13
     */
    public int getAssumptionFailureCount() {
        
    }

    /**
     * @return <code>true</code> if all tests succeeded
     */
    public boolean wasSuccessful() {
        
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        
    }

    private void readObject(ObjectInputStream s)
            throws ClassNotFoundException, IOException {
        
    }

    private Object readResolve()  {
        
    }

    @RunListener.ThreadSafe
    private class Listener extends RunListener {
        @Override
        public void testRunStarted(Description description) throws Exception {
            
        }

        @Override
        public void testRunFinished(Result result) throws Exception {
            
        }

        @Override
        public void testFinished(Description description) throws Exception {
            
        }

        @Override
        public void testFailure(Failure failure) throws Exception {
            
        }

        @Override
        public void testIgnored(Description description) throws Exception {
            
        }

        @Override
        public void testAssumptionFailure(Failure failure) {
            
        }
    }

    /**
     * Internal use only.
     */
    public RunListener createListener() {
        
    }

    /**
     * Represents the serialized output of {@code Result}. The fields on this
     * class match the files that {@code Result} had in JUnit 4.11.
     */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 1L;
        private final AtomicInteger fCount;
        private final AtomicInteger fIgnoreCount;
        private final AtomicInteger assumptionFailureCount;
        private final List<Failure> fFailures;
        private final long fRunTime;
        private final long fStartTime;

        public SerializedForm(Result result) {
            
        }

        @SuppressWarnings("unchecked")
        private SerializedForm(ObjectInputStream.GetField fields) throws IOException, ClassNotFoundException {
            
        }

        public void serialize(ObjectOutputStream s) throws IOException {
            
        }

        public static SerializedForm deserialize(ObjectInputStream s)
                throws ClassNotFoundException, IOException {
            
        }
    }
}
