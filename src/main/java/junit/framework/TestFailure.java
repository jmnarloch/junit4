package junit.framework;

import org.junit.internal.Throwables;


/**
 * A {@code TestFailure} collects a failed test together with
 * the caught exception.
 *
 * @see TestResult
 */
public class TestFailure {
    protected Test fFailedTest;
    protected Throwable fThrownException;

    /**
     * Constructs a TestFailure with the given test and exception.
     */
    public TestFailure(Test failedTest, Throwable thrownException) {
        
    }

    /**
     * Gets the failed test.
     */
    public Test failedTest() {
        
    }

    /**
     * Gets the thrown exception.
     */
    public Throwable thrownException() {
        
    }

    /**
     * Returns a short description of the failure.
     */
    @Override
    public String toString() {
        
    }
    
    /**
     * Returns a String containing the stack trace of the error
     * thrown by TestFailure.
     */
    public String trace() {
        
    }

    /**
     * Returns a String containing the message from the thrown exception.
     */
    public String exceptionMessage() {
        
    }

    /**
     * Returns {@code true} if the error is considered a failure
     * (i.e. if it is an instance of {@code AssertionFailedError}),
     * {@code false} otherwise.
     */
    public boolean isFailure() {
        
    }
}