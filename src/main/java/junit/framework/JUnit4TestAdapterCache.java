package junit.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class JUnit4TestAdapterCache extends HashMap<Description, Test> {
    private static final long serialVersionUID = 1L;
    private static final JUnit4TestAdapterCache fInstance = new JUnit4TestAdapterCache();

    public static JUnit4TestAdapterCache getDefault() {
        
    }

    public Test asTest(Description description) {
        
    }

    Test createTest(Description description) {
        
    }

    public RunNotifier getNotifier(final TestResult result, final JUnit4TestAdapter adapter) {
        
    }

    public List<Test> asTestList(Description description) {
        
    }

}