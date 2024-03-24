package junit.textui;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;

public class ResultPrinter implements TestListener {
    PrintStream fWriter;
    int fColumn = 0;

    public ResultPrinter(PrintStream writer) {
        
    }

    /* API for use by textui.TestRunner */

    synchronized void print(TestResult result, long runTime) {
        
    }

    void printWaitPrompt() {
        
    }

    /* Internal methods */

    protected void printHeader(long runTime) {
        
    }

    protected void printErrors(TestResult result) {
        
    }

    protected void printFailures(TestResult result) {
        
    }

    protected void printDefects(Enumeration<TestFailure> booBoos, int count, String type) {
        
    }

    public void printDefect(TestFailure booBoo, int count) { // only public for testing purposes
        
    }

    protected void printDefectHeader(TestFailure booBoo, int count) {
        // I feel like making this a println, then adding a line giving the throwable a chance to print something
        // before we get to the stack trace.
        
    }

    protected void printDefectTrace(TestFailure booBoo) {
        
    }

    protected void printFooter(TestResult result) {
        
    }

    /**
     * Returns the formatted string of the elapsed time.
     * Duplicated from BaseTestRunner. Fix it.
     */
    protected String elapsedTimeAsString(long runTime) {
        
    }

    public PrintStream getWriter() {
        
    }

    /**
     * @see junit.framework.TestListener#addError(Test, Throwable)
     */
    public void addError(Test test, Throwable e) {
        
    }

    /**
     * @see junit.framework.TestListener#addFailure(Test, AssertionFailedError)
     */
    public void addFailure(Test test, AssertionFailedError t) {
        
    }

    /**
     * @see junit.framework.TestListener#endTest(Test)
     */
    public void endTest(Test test) { }

    /**
     * @see junit.framework.TestListener#startTest(Test)
     */
    public void startTest(Test test) {
        
    }

}
