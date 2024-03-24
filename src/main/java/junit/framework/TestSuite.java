package junit.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import org.junit.internal.MethodSorter;
import org.junit.internal.Throwables;

/**
 * A <code>TestSuite</code> is a <code>Composite</code> of Tests.
 * It runs a collection of test cases. Here is an example using
 * the dynamic test definition.
 * <pre>
 * TestSuite suite= new TestSuite();
 * suite.addTest(new MathTest("testAdd"));
 * suite.addTest(new MathTest("testDivideByZero"));
 * </pre>
 * <p>
 * Alternatively, a TestSuite can extract the tests to be run automatically.
 * To do so you pass the class of your TestCase class to the
 * TestSuite constructor.
 * <pre>
 * TestSuite suite= new TestSuite(MathTest.class);
 * </pre>
 * <p>
 * This constructor creates a suite with all the methods
 * starting with "test" that take no arguments.
 * <p>
 * A final option is to do the same for a large array of test classes.
 * <pre>
 * Class[] testClasses = { MathTest.class, AnotherTest.class };
 * TestSuite suite= new TestSuite(testClasses);
 * </pre>
 *
 * @see Test
 */
public class TestSuite implements Test {

    /**
     * ...as the moon sets over the early morning Merlin, Oregon
     * mountains, our intrepid adventurers type...
     */
    static public Test createTest(Class<?> theClass, String name) {
        
    }

    /**
     * Gets a constructor which takes a single String as
     * its argument or a no arg constructor.
     */
    public static Constructor<?> getTestConstructor(Class<?> theClass) throws NoSuchMethodException {
        
    }

    /**
     * Returns a test which will fail and log a warning message.
     */
    public static Test warning(final String message) {
        
    }

    private String fName;

    private Vector<Test> fTests = new Vector<Test>(10); // Cannot convert this to List because it is used directly by some test runners

    /**
     * Constructs an empty TestSuite.
     */
    public TestSuite() { }

    /**
     * Constructs a TestSuite from the given class. Adds all the methods
     * starting with "test" as test cases to the suite.
     * Parts of this method were written at 2337 meters in the Hueffihuette,
     * Kanton Uri
     */
    public TestSuite(final Class<?> theClass) {
        
    }

    private void addTestsFromTestCase(final Class<?> theClass) {
        
    }

    /**
     * Constructs a TestSuite from the given class with the given name.
     *
     * @see TestSuite#TestSuite(Class)
     */
    public TestSuite(Class<? extends TestCase> theClass, String name) {
        
    }

    /**
     * Constructs an empty TestSuite.
     */
    public TestSuite(String name) {
        
    }

    /**
     * Constructs a TestSuite from the given array of classes.
     *
     * @param classes {@link TestCase}s
     */
    public TestSuite(Class<?>... classes) {
        
    }

    private Test testCaseForClass(Class<?> each) {
        
    }

    /**
     * Constructs a TestSuite from the given array of classes with the given name.
     *
     * @see TestSuite#TestSuite(Class[])
     */
    public TestSuite(Class<? extends TestCase>[] classes, String name) {
        
    }

    /**
     * Adds a test to the suite.
     */
    public void addTest(Test test) {
        
    }

    /**
     * Adds the tests from the given class to the suite.
     */
    public void addTestSuite(Class<? extends TestCase> testClass) {
        
    }

    /**
     * Counts the number of test cases that will be run by this test.
     */
    public int countTestCases() {
        
    }

    /**
     * Returns the name of the suite. Not all
     * test suites have a name and this method
     * can return null.
     */
    public String getName() {
        
    }

    /**
     * Runs the tests and collects their result in a TestResult.
     */
    public void run(TestResult result) {
        
    }

    public void runTest(Test test, TestResult result) {
        
    }

    /**
     * Sets the name of the suite.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        
    }

    /**
     * Returns the test at the given index.
     */
    public Test testAt(int index) {
        
    }

    /**
     * Returns the number of tests in this suite.
     */
    public int testCount() {
        
    }

    /**
     * Returns the tests as an enumeration.
     */
    public Enumeration<Test> tests() {
        
    }

    /**
     */
    @Override
    public String toString() {
        
    }

    private void addTestMethod(Method m, List<String> names, Class<?> theClass) {
        
    }

    private boolean isPublicTestMethod(Method m) {
        
    }

    private boolean isTestMethod(Method m) {
        
    }
}
