package junit.extensions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * A TestSuite for active Tests. It runs each
 * test in a separate thread and waits until all
 * threads have terminated.
 * -- Aarhus Radisson Scandinavian Center 11th floor
 */
public class ActiveTestSuite extends TestSuite {
    private volatile int fActiveTestDeathCount;

    public ActiveTestSuite() { }

    public ActiveTestSuite(Class<? extends TestCase> theClass) {
        
    }

    public ActiveTestSuite(String name) {
        
    }

    public ActiveTestSuite(Class<? extends TestCase> theClass, String name) {
        
    }

    @Override
    public void run(TestResult result) {
        
    }

    @Override
    public void runTest(final Test test, final TestResult result) {
        
    }

    synchronized void waitUntilFinished() {
        
    }

    public synchronized void runFinished() {
        
    }
}