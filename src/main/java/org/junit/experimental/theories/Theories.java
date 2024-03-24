package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

/**
 * The Theories runner allows to test a certain functionality against a subset of an infinite set of data points.
 * <p>
 * A Theory is a piece of functionality (a method) that is executed against several data inputs called data points.
 * To make a test method a theory you mark it with <b>&#064;Theory</b>. To create a data point you create a public
 * field in your test class and mark it with <b>&#064;DataPoint</b>. The Theories runner then executes your test
 * method as many times as the number of data points declared, providing a different data point as
 * the input argument on each invocation.
 * </p>
 * <p>
 * A Theory differs from standard test method in that it captures some aspect of the intended behavior in possibly
 * infinite numbers of scenarios which corresponds to the number of data points declared. Using assumptions and
 * assertions properly together with covering multiple scenarios with different data points can make your tests more
 * flexible and bring them closer to scientific theories (hence the name).
 * </p>
 * <p>
 * For example:
 * <pre>
 *
 * &#064;RunWith(<b>Theories.class</b>)
 * public class UserTest {
 *      <b>&#064;DataPoint</b>
 *      public static String GOOD_USERNAME = "optimus";
 *      <b>&#064;DataPoint</b>
 *      public static String USERNAME_WITH_SLASH = "optimus/prime";
 *
 *      <b>&#064;Theory</b>
 *      public void filenameIncludesUsername(String username) {
 *          assumeThat(username, not(containsString("/")));
 *          assertThat(new User(username).configFileName(), containsString(username));
 *      }
 * }
 * </pre>
 * This makes it clear that the username should be included in the config file name,
 * only if it doesn't contain a slash. Another test or theory might define what happens when a username does contain
 * a slash. <code>UserTest</code> will attempt to run <code>filenameIncludesUsername</code> on every compatible data
 * point defined in the class. If any of the assumptions fail, the data point is silently ignored. If all of the
 * assumptions pass, but an assertion fails, the test fails. If no parameters can be found that satisfy all assumptions, the test fails.
 * <p>
 * Defining general statements as theories allows data point reuse across a bunch of functionality tests and also
 * allows automated tools to search for new, unexpected data points that expose bugs.
 * </p>
 * <p>
 * The support for Theories has been absorbed from the Popper project, and more complete documentation can be found
 * from that projects archived documentation.
 * </p>
 *
 * @see <a href="http://web.archive.org/web/20071012143326/popper.tigris.org/tutorial.html">Archived Popper project documentation</a>
 * @see <a href="http://web.archive.org/web/20110608210825/http://shareandenjoy.saff.net/tdd-specifications.pdf">Paper on Theories</a>
 */
public class Theories extends BlockJUnit4ClassRunner {
    public Theories(Class<?> klass) throws InitializationError {
        
    }

    /** @since 4.13 */
    protected Theories(TestClass testClass) throws InitializationError {
        
    }

    @Override
    protected void collectInitializationErrors(List<Throwable> errors) {
        
    }

    private void validateDataPointFields(List<Throwable> errors) {
        
    }

    private void validateDataPointMethods(List<Throwable> errors) {
        
    }

    @Override
    protected void validateConstructor(List<Throwable> errors) {
        
    }

    @Override
    protected void validateTestMethods(List<Throwable> errors) {
        
    }

    private void validateParameterSupplier(Class<? extends ParameterSupplier> supplierClass, List<Throwable> errors) {
        
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        
    }

    @Override
    public Statement methodBlock(final FrameworkMethod method) {
        
    }

    public static class TheoryAnchor extends Statement {
        private int successes = 0;

        private final FrameworkMethod testMethod;
        private final TestClass testClass;

        private List<AssumptionViolatedException> fInvalidParameters = new ArrayList<AssumptionViolatedException>();

        public TheoryAnchor(FrameworkMethod testMethod, TestClass testClass) {
            
        }

        private TestClass getTestClass() {
            
        }

        @Override
        public void evaluate() throws Throwable {
            
        }

        protected void runWithAssignment(Assignments parameterAssignment)
                throws Throwable {
            
        }

        protected void runWithIncompleteAssignment(Assignments incomplete)
                throws Throwable {
            
        }

        protected void runWithCompleteAssignment(final Assignments complete)
                throws Throwable {
            
        }

        private Statement methodCompletesWithParameters(
                final FrameworkMethod method, final Assignments complete, final Object freshInstance) {
            
        }

        protected void handleAssumptionViolation(AssumptionViolatedException e) {
            
        }

        protected void reportParameterizedError(Throwable e, Object... params)
                throws Throwable {
            
        }

        private boolean nullsOk() {
            
        }

        protected void handleDataPointSuccess() {
            
        }
    }
}
