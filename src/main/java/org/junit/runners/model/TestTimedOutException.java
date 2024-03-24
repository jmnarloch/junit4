package org.junit.runners.model;

import java.util.concurrent.TimeUnit;

/**
 * Exception thrown when a test fails on timeout.
 * 
 * @since 4.12
 * 
 */
public class TestTimedOutException extends Exception {

    private static final long serialVersionUID = 31935685163547539L;

    private final TimeUnit timeUnit;
    private final long timeout;

    /**
     * Creates exception with a standard message "test timed out after [timeout] [timeUnit]"
     * 
     * @param timeout the amount of time passed before the test was interrupted
     * @param timeUnit the time unit for the timeout value
     */
    public TestTimedOutException(long timeout, TimeUnit timeUnit) {
        
    }

    /**
     * Gets the time passed before the test was interrupted
     */
    public long getTimeout() {
        
    }

    /**
     * Gets the time unit for the timeout value
     */
    public TimeUnit getTimeUnit() {
        
    }
}
