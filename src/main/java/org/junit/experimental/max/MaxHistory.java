package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * Stores a subset of the history of each test:
 * <ul>
 * <li>Last failure timestamp
 * <li>Duration of last execution
 * </ul>
 */
public class MaxHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Loads a {@link MaxHistory} from {@code file}, or generates a new one that
     * will be saved to {@code file}.
     */
    public static MaxHistory forFolder(File file) {
        
    }

    private static MaxHistory readHistory(File storedResults)
            throws CouldNotReadCoreException {
        
    }

    /*
     * We have to use the f prefix until the next major release to ensure
     * serialization compatibility. 
     * See https://github.com/junit-team/junit4/issues/976
     */
    private final Map<String, Long> fDurations = new HashMap<String, Long>();
    private final Map<String, Long> fFailureTimestamps = new HashMap<String, Long>();
    private final File fHistoryStore;

    private MaxHistory(File storedResults) {
        
    }

    private void save() throws IOException {
        
    }

    Long getFailureTimestamp(Description key) {
        
    }

    void putTestFailureTimestamp(Description key, long end) {
        
    }

    boolean isNewTest(Description key) {
        
    }

    Long getTestDuration(Description key) {
        
    }

    void putTestDuration(Description description, long duration) {
        
    }

    private final class RememberingListener extends RunListener {
        private long overallStart = System.currentTimeMillis();

        private Map<Description, Long> starts = new HashMap<Description, Long>();

        @Override
        public void testStarted(Description description) throws Exception {
             // Get most accurate
            // possible time
        }

        @Override
        public void testFinished(Description description) throws Exception {
            
        }

        @Override
        public void testFailure(Failure failure) throws Exception {
            
        }

        @Override
        public void testRunFinished(Result result) throws Exception {
            
        }
    }

    private class TestComparator implements Comparator<Description> {
        public int compare(Description o1, Description o2) {
            // Always prefer new tests
            
        }

        private Long getFailure(Description key) {
            
        }
    }

    /**
     * @return a listener that will update this history based on the test
     *         results reported.
     */
    public RunListener listener() {
        
    }

    /**
     * @return a comparator that ranks tests based on the JUnit Max sorting
     *         rules, as described in the {@link MaxCore} class comment.
     */
    public Comparator<Description> testComparator() {
        
    }
}
