package junit.extensions;

import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestResult;

/**
 * A Decorator to set up and tear down additional fixture state. Subclass
 * TestSetup and insert it into your tests when you want to set up additional
 * state once before the tests are run.
 */
public class TestSetup extends TestDecorator {

    public TestSetup(Test test) {
        
    }

    @Override
    public void run(final TestResult result) {
        
    }

    /**
     * Sets up the fixture. Override to set up additional fixture state.
     */
    protected void setUp() throws Exception { }

    /**
     * Tears down the fixture. Override to tear down the additional fixture
     * state.
     */
    protected void tearDown() throws Exception { }
}