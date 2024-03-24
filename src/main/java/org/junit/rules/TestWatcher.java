package org.junit.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/**
 * TestWatcher is a base class for Rules that take note of the testing
 * action, without modifying it. For example, this class will keep a log of each
 * passing and failing test:
 *
 * <pre>
 * public static class WatchmanTest {
 *  private static String watchedLog;
 *
 *  &#064;Rule(order = Integer.MIN_VALUE)
 *  public TestWatcher watchman= new TestWatcher() {
 *      &#064;Override
 *      protected void failed(Throwable e, Description description) {
 *          watchedLog+= description + &quot;\n&quot;;
 *      }
 *
 *      &#064;Override
 *      protected void succeeded(Description description) {
 *          watchedLog+= description + &quot; &quot; + &quot;success!\n&quot;;
 *         }
 *     };
 *
 *  &#064;Test
 *  public void fails() {
 *      fail();
 *  }
 *
 *  &#064;Test
 *  public void succeeds() {
 *     }
 * }
 * </pre>
 * <p>It is recommended to always set the {@link Rule#order() order} of the
 * {@code TestWatcher} to {@code Integer.MIN_VALUE} so that it encloses all
 * other rules. Otherwise it may see failed tests as successful and vice versa
 * if some rule changes the result of a test (e.g. {@link ErrorCollector} or
 * {@link ExpectedException}).
 *
 * @since 4.9
 */
public abstract class TestWatcher implements TestRule {
    public Statement apply(final Statement base, final Description description) {
        
    }

    private void succeededQuietly(Description description,
            List<Throwable> errors) {
        
    }

    private void failedQuietly(Throwable e, Description description,
            List<Throwable> errors) {
        
    }

    private void skippedQuietly(
            org.junit.internal.AssumptionViolatedException e, Description description,
            List<Throwable> errors) {
        
    }

    private void startingQuietly(Description description,
            List<Throwable> errors) {
        
    }

    private void finishedQuietly(Description description,
            List<Throwable> errors) {
        
    }

    /**
     * Invoked when a test succeeds
     */
    protected void succeeded(Description description) { }

    /**
     * Invoked when a test fails
     */
    protected void failed(Throwable e, Description description) { }

    /**
     * Invoked when a test is skipped due to a failed assumption.
     */
    protected void skipped(AssumptionViolatedException e, Description description) {
        // For backwards compatibility with JUnit 4.11 and earlier, call the legacy version
        
    }

    /**
     * Invoked when a test is skipped due to a failed assumption.
     *
     * @deprecated use {@link #skipped(AssumptionViolatedException, Description)}
     */
    @Deprecated
    protected void skipped(
            org.junit.internal.AssumptionViolatedException e, Description description) { }

    /**
     * Invoked when a test is about to start
     */
    protected void starting(Description description) { }

    /**
     * Invoked when a test method finishes (whether passing or failing)
     */
    protected void finished(Description description) { }
}
