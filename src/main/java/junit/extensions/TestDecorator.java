package junit.extensions;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestResult;

/**
 * A Decorator for Tests. Use TestDecorator as the base class for defining new
 * test decorators. Test decorator subclasses can be introduced to add behaviour
 * before or after a test is run.
 */
@SuppressWarnings("deprecation")
public class TestDecorator extends Assert implements Test {
    protected Test fTest;

    public TestDecorator(Test test) {
        
    }

    /**
     * The basic run behaviour.
     */
    public void basicRun(TestResult result) {
        
    }

    public int countTestCases() {
        
    }

    public void run(TestResult result) {
        
    }

    @Override
    public String toString() {
        
    }

    public Test getTest() {
        
    }
}