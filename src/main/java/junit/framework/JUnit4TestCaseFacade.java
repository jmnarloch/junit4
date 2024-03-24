package junit.framework;

import org.junit.runner.Describable;
import org.junit.runner.Description;

public class JUnit4TestCaseFacade implements Test, Describable {
    private final Description fDescription;

    JUnit4TestCaseFacade(Description description) {
        
    }

    @Override
    public String toString() {
        
    }

    public int countTestCases() { }

    public void run(TestResult result) {
        
    }

    public Description getDescription() {
        
    }
}