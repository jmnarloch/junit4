package org.junit.experimental.results;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * A test result that prints nicely in error messages.
 * This is only intended to be used in JUnit self-tests.
 * For example:
 *
 * <pre>
 *    assertThat(testResult(HasExpectedException.class), isSuccessful());
 * </pre>
 */
public class PrintableResult {
    private Result result;

    /**
     * The result of running JUnit on {@code type}
     */
    public static PrintableResult testResult(Class<?> type) {
        
    }

    /**
     * The result of running JUnit on Request {@code request}
     */
    public static PrintableResult testResult(Request request) {
        
    }

    /**
     * A result that includes the given {@code failures}
     */
    public PrintableResult(List<Failure> failures) {
        
    }

    private PrintableResult(Result result) {
        
    }

    /**
     * Returns the number of failures in this result.
     */
    public int failureCount() {
        
    }

    /**
     * Returns the failures in this result.
     *
     * @since 4.13
     */
    public List<Failure> failures() {
        
    }

    @Override
    public String toString() {
        
    }
}