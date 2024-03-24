package org.junit.experimental.max;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestSuite;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/**
 * A replacement for JUnitCore, which keeps track of runtime and failure history, and reorders tests
 * to maximize the chances that a failing test occurs early in the test run.
 *
 * The rules for sorting are:
 * <ol>
 * <li> Never-run tests first, in arbitrary order
 * <li> Group remaining tests by the date at which they most recently failed.
 * <li> Sort groups such that the most recent failure date is first, and never-failing tests are at the end.
 * <li> Within a group, run the fastest tests first.
 * </ol>
 */
public class MaxCore {
    private static final String MALFORMED_JUNIT_3_TEST_CLASS_PREFIX = "malformed JUnit 3 test class: ";

    /**
     * Create a new MaxCore from a serialized file stored at storedResults
     *
     * @deprecated use storedLocally()
     */
    @Deprecated
    public static MaxCore forFolder(String folderName) {
        
    }

    /**
     * Create a new MaxCore from a serialized file stored at storedResults
     */
    public static MaxCore storedLocally(File storedResults) {
        
    }

    private final MaxHistory history;

    private MaxCore(File storedResults) {
        
    }

    /**
     * Run all the tests in <code>class</code>.
     *
     * @return a {@link Result} describing the details of the test run and the failed tests.
     */
    public Result run(Class<?> testClass) {
        
    }

    /**
     * Run all the tests contained in <code>request</code>.
     *
     * @param request the request describing tests
     * @return a {@link Result} describing the details of the test run and the failed tests.
     */
    public Result run(Request request) {
        
    }

    /**
     * Run all the tests contained in <code>request</code>.
     *
     * This variant should be used if {@code core} has attached listeners that this
     * run should notify.
     *
     * @param request the request describing tests
     * @param core a JUnitCore to delegate to.
     * @return a {@link Result} describing the details of the test run and the failed tests.
     */
    public Result run(Request request, JUnitCore core) {
        
    }

    /**
     * @return a new Request, which contains all of the same tests, but in a new order.
     */
    public Request sortRequest(Request request) {
        
    }

    private Request constructLeafRequest(List<Description> leaves) {
        
    }

    private Runner buildRunner(Description each) {
        
    }

    private Class<?> getMalformedTestClass(Description each) {
        
    }

    /**
     * @param request a request to run
     * @return a list of method-level tests to run, sorted in the order
     *         specified in the class comment.
     */
    public List<Description> sortedLeavesForTest(Request request) {
        
    }

    private List<Description> findLeaves(Request request) {
        
    }

    private void findLeaves(Description parent, Description description, List<Description> results) {
        
    }
}