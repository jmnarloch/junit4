package org.junit.runners.model;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.TestCouldNotBeSkippedException;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.Throwables;

/**
 * Collects multiple {@code Throwable}s into one exception.
 *
 * @since 4.9
 */
public class MultipleFailureException extends Exception {
    private static final long serialVersionUID = 1L;

    /*
     * We have to use the f prefix until the next major release to ensure
     * serialization compatibility. 
     * See https://github.com/junit-team/junit4/issues/976
     */
    private final List<Throwable> fErrors;

    public MultipleFailureException(List<Throwable> errors) {
        
    }

    public List<Throwable> getFailures() {
        
    }

    @Override
    public String getMessage() {
        
    }

    @Override
    public void printStackTrace() {
        
    }
    
    @Override
    public void printStackTrace(PrintStream s) {
        
    }
    
    @Override
    public void printStackTrace(PrintWriter s) {
        
    }
    
    /**
     * Asserts that a list of throwables is empty. If it isn't empty,
     * will throw {@link MultipleFailureException} (if there are
     * multiple throwables in the list) or the first element in the list
     * (if there is only one element).
     *
     * @param errors list to check
     * @throws Exception or Error if the list is not empty
     */
    @SuppressWarnings("deprecation")
    public static void assertEmpty(List<Throwable> errors) throws Exception {
        
    }
}
