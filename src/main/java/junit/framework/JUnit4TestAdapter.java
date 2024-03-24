package junit.framework;

import java.util.List;

import org.junit.Ignore;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Sorter;

/**
 * The JUnit4TestAdapter enables running JUnit-4-style tests using a JUnit-3-style test runner.
 *
 * <p> To use it, add the following to a test class:
 * <pre>
      public static Test suite() {
        return new JUnit4TestAdapter(<em>YourJUnit4TestClass</em>.class);
      }
</pre>
 */
public class JUnit4TestAdapter implements Test, Filterable, Orderable, Describable {
    private final Class<?> fNewTestClass;

    private final Runner fRunner;

    private final JUnit4TestAdapterCache fCache;

    public JUnit4TestAdapter(Class<?> newTestClass) {
        
    }

    public JUnit4TestAdapter(final Class<?> newTestClass, JUnit4TestAdapterCache cache) {
        
    }

    public int countTestCases() {
        
    }

    public void run(TestResult result) {
        
    }

    // reflective interface for Eclipse
    public List<Test> getTests() {
        
    }

    // reflective interface for Eclipse
    public Class<?> getTestClass() {
        
    }

    public Description getDescription() {
        
    }

    private Description removeIgnored(Description description) {
        
    }

    private boolean isIgnored(Description description) {
        
    }

    @Override
    public String toString() {
        
    }

    public void filter(Filter filter) throws NoTestsRemainException {
        
    }

    public void sort(Sorter sorter) {
        
    }

    /**
     * {@inheritDoc}
     *
     * @since 4.13
     */
    public void order(Orderer orderer) throws InvalidOrderingException {
        
    }
}