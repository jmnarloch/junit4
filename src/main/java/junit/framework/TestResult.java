package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * A <code>TestResult</code> collects the results of executing
 * a test case. It is an instance of the Collecting Parameter pattern.
 * The test framework distinguishes between <i>failures</i> and <i>errors</i>.
 * A failure is anticipated and checked for with assertions. Errors are
 * unanticipated problems like an {@link ArrayIndexOutOfBoundsException}.
 *
 * @see Test
 */
public class TestResult {
    protected List<TestFailure> fFailures;
    protected List<TestFailure> fErrors;
    protected List<TestListener> fListeners;
    protected int fRunTests;
    private boolean fStop;

    public TestResult() {
        
    }

    /**
     * Adds an error to the list of errors. The passed in exception
     * caused the error.
     */
    public synchronized void addError(Test test, Throwable e) {
        
    }

    /**
     * Adds a failure to the list of failures. The passed in exception
     * caused the failure.
     */
    public synchronized void addFailure(Test test, AssertionFailedError e) {
        
    }

    /**
     * Registers a TestListener.
     */
    public synchronized void addListener(TestListener listener) {
        
    }

    /**
     * Unregisters a TestListener.
     */
    public synchronized void removeListener(TestListener listener) {
        
    }

    /**
     * Returns a copy of the listeners.
     */
    private synchronized List<TestListener> cloneListeners() {
        
    }

    /**
     * Informs the result that a test was completed.
     */
    public void endTest(Test test) {
        
    }

    /**
     * Gets the number of detected errors.
     */
    public synchronized int errorCount() {
        
    }

    /**
     * Returns an Enumeration for the errors.
     */
    public synchronized Enumeration<TestFailure> errors() {
        
    }


    /**
     * Gets the number of detected failures.
     */
    public synchronized int failureCount() {
        
    }

    /**
     * Returns an Enumeration for the failures.
     */
    public synchronized Enumeration<TestFailure> failures() {
        
    }

    /**
     * Runs a TestCase.
     */
    protected void run(final TestCase test) {
        
    }

    /**
     * Gets the number of run tests.
     */
    public synchronized int runCount() {
        
    }

    /**
     * Runs a TestCase.
     */
    public void runProtected(final Test test, Protectable p) {
        
    }

    /**
     * Checks whether the test run should stop.
     */
    public synchronized boolean shouldStop() {
        
    }

    /**
     * Informs the result that a test will be started.
     */
    public void startTest(Test test) {
        
    }

    /**
     * Marks that the test run should stop.
     */
    public synchronized void stop() {
        
    }

    /**
     * Returns whether the entire test was successful or not.
     */
    public synchronized boolean wasSuccessful() {
        
    }
}
