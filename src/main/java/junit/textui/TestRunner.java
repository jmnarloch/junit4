package junit.textui;


import java.io.PrintStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.Version;

/**
 * A command line based tool to run tests.
 * <pre>
 * java junit.textui.TestRunner [-wait] TestCaseClass
 * </pre>
 * <p>
 * TestRunner expects the name of a TestCase class as argument.
 * If this class defines a static <code>suite</code> method it
 * will be invoked and the returned test is run. Otherwise all
 * the methods starting with "test" having no arguments are run.
 * <p>
 * When the wait command line argument is given TestRunner
 * waits until the users types RETURN.
 * <p>
 * TestRunner prints a trace as the tests are executed followed by a
 * summary at the end.
 */
public class TestRunner extends BaseTestRunner {
    private ResultPrinter fPrinter;

    public static final int SUCCESS_EXIT = 0;
    public static final int FAILURE_EXIT = 1;
    public static final int EXCEPTION_EXIT = 2;

    /**
     * Constructs a TestRunner.
     */
    public TestRunner() {
        
    }

    /**
     * Constructs a TestRunner using the given stream for all the output
     */
    public TestRunner(PrintStream writer) {
        
    }

    /**
     * Constructs a TestRunner using the given ResultPrinter all the output
     */
    public TestRunner(ResultPrinter printer) {
        
    }

    /**
     * Runs a suite extracted from a TestCase subclass.
     */
    static public void run(Class<? extends TestCase> testClass) {
        
    }

    /**
     * Runs a single test and collects its results.
     * This method can be used to start a test run
     * from your program.
     * <pre>
     * public static void main (String[] args) {
     *    test.textui.TestRunner.run(suite());
     * }
     * </pre>
     */
    static public TestResult run(Test test) {
        
    }

    /**
     * Runs a single test and waits until the user
     * types RETURN.
     */
    static public void runAndWait(Test suite) {
        
    }

    @Override
    public void testFailed(int status, Test test, Throwable e) { }

    @Override
    public void testStarted(String testName) { }

    @Override
    public void testEnded(String testName) { }

    /**
     * Creates the TestResult to be used for the test run.
     */
    protected TestResult createTestResult() {
        
    }

    public TestResult doRun(Test test) {
        
    }

    public TestResult doRun(Test suite, boolean wait) {
        
    }

    protected void pause(boolean wait) {
        
    }

    public static void main(String[] args) {
        
    }

    /**
     * Starts a test run. Analyzes the command line arguments and runs the given
     * test suite.
     */
    public TestResult start(String[] args) throws Exception {
        
    }

    protected TestResult runSingleMethod(String testCase, String method, boolean wait) throws Exception {
        
    }

    @Override
    protected void runFailed(String message) {
        
    }

    public void setPrinter(ResultPrinter printer) {
        
    }


}