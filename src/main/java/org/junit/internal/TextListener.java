package org.junit.internal;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TextListener extends RunListener {

    private final PrintStream writer;

    public TextListener(JUnitSystem system) {
        
    }

    public TextListener(PrintStream writer) {
        
    }

    @Override
    public void testRunFinished(Result result) {
        
    }

    @Override
    public void testStarted(Description description) {
        
    }

    @Override
    public void testFailure(Failure failure) {
        
    }

    @Override
    public void testIgnored(Description description) {
        
    }

    /*
      * Internal methods
      */

    private PrintStream getWriter() {
        
    }

    protected void printHeader(long runTime) {
        
    }

    protected void printFailures(Result result) {
        
    }

    protected void printFailure(Failure each, String prefix) {
        
    }

    protected void printFooter(Result result) {
        
    }

    /**
     * Returns the formatted string of the elapsed time. Duplicated from
     * BaseTestRunner. Fix it.
     */
    protected String elapsedTimeAsString(long runTime) {
        
    }
}
