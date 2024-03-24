package junit.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestSuite;

import org.junit.internal.Throwables;

/**
 * Base class for all test runners.
 * This class was born live on stage in Sardinia during XP2000.
 */
public abstract class BaseTestRunner implements TestListener {
    public static final String SUITE_METHODNAME = "suite";

    private static Properties fPreferences;
    static int fgMaxMessageLength = 500;
    static boolean fgFilterStack = true;
    boolean fLoading = true;

    /*
    * Implementation of TestListener
    */
    public synchronized void startTest(Test test) {
        
    }

    protected static void setPreferences(Properties preferences) {
        
    }

    protected static Properties getPreferences() {
        
    }

    public static void savePreferences() throws IOException {
        
    }

    public static void setPreference(String key, String value) {
        
    }

    public synchronized void endTest(Test test) {
        
    }

    public synchronized void addError(final Test test, final Throwable e) {
        
    }

    public synchronized void addFailure(final Test test, final AssertionFailedError e) {
        
    }

    // TestRunListener implementation

    public abstract void testStarted(String testName);

    public abstract void testEnded(String testName);

    public abstract void testFailed(int status, Test test, Throwable e);

    /**
     * Returns the Test corresponding to the given suite. This is
     * a template method, subclasses override runFailed(), clearStatus().
     */
    public Test getTest(String suiteClassName) {
        
    }

    /**
     * Returns the formatted string of the elapsed time.
     */
    public String elapsedTimeAsString(long runTime) {
        
    }

    /**
     * Processes the command line arguments and
     * returns the name of the suite class to run or null
     */
    protected String processArguments(String[] args) {
        
    }

    /**
     * Sets the loading behaviour of the test runner
     */
    public void setLoading(boolean enable) {
        
    }

    /**
     * Extract the class name from a String in VA/Java style
     */
    public String extractClassName(String className) {
        
    }

    /**
     * Truncates a String to the maximum length.
     */
    public static String truncate(String s) {
        
    }

    /**
     * Override to define how to handle a failed loading of
     * a test suite.
     */
    protected abstract void runFailed(String message);

    /**
     * Returns the loaded Class for a suite name.
     */
    protected Class<?> loadSuiteClass(String suiteClassName) throws ClassNotFoundException {
        
    }

    /**
     * Clears the status message.
     */
    protected void clearStatus() { }

    protected boolean useReloadingTestSuiteLoader() {
        
    }

    private static File getPreferencesFile() {
        
    }

    private static void readPreferences() {
        
    }

    public static String getPreference(String key) {
        
    }

    public static int getPreference(String key, int dflt) {
        
    }

    /**
     * Returns a filtered stack trace
     */
    public static String getFilteredTrace(Throwable e) {
        
    }

    /**
     * Filters stack frames from internal JUnit classes
     */
    public static String getFilteredTrace(String stack) {
        
    }

    protected static boolean showStackRaw() {
        
    }

    static boolean filterLine(String line) {
        
    }

    static {
        fgMaxMessageLength = getPreference("maxmessage", fgMaxMessageLength);
    }

}
