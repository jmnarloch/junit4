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
        if (file == null) {
            throw new IllegalArgumentException(
            "For MaxHistory.forFolder, file cannot be null");
        }
        return new MaxHistory(new File(file, "surefire"));
    }

    private static MaxHistory readHistory(File storedResults)
            throws CouldNotReadCoreException {
        try {
            FileInputStream file = new FileInputStream(storedResults);
            try {
                ObjectInputStream stream = new ObjectInputStream(file);
                try {
                    return (MaxHistory) stream.readObject();
                } finally {
                    stream.close();
                }
            } finally {
                file.close();
            }
        } catch (Exception e) {
            throw new CouldNotReadCoreException(e);
        }
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
        fHistoryStore = storedResults;
    }

    private void save() throws IOException {
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(fHistoryStore));
            stream.writeObject(this);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    Long getFailureTimestamp(Description key) {
        return fFailureTimestamps.get(key.toString());
    }

    void putTestFailureTimestamp(Description key, long end) {
        fFailureTimestamps.put(key.toString(), end);
    }

    boolean isNewTest(Description key) {
        return !fDurations.containsKey(key.toString());
    }

    Long getTestDuration(Description key) {
        return fDurations.get(key.toString());
    }

    void putTestDuration(Description description, long duration) {
        fDurations.put(description.toString(), duration);
    }

    private final class RememberingListener extends RunListener {
        private long overallStart = System.currentTimeMillis();

        private Map<Description, Long> starts = new HashMap<Description, Long>();

        @Override
        public void testStarted(Description description) throws Exception {
            // Get most accurate
            // possible time
            starts.put(description, System.currentTimeMillis());
        }

        @Override
        public void testFinished(Description description) throws Exception {
            long end = System.currentTimeMillis();
            putTestDuration(description, end - starts.get(description));
        }

        @Override
        public void testFailure(Failure failure) throws Exception {
            Description description = failure.getDescription();
            putTestFailureTimestamp(description, System.currentTimeMillis());
        }

        @Override
        public void testRunFinished(Result result) throws Exception {
            for (Description description : result.getRunOrder()) {
                if (description.isTest()) {
                    putTestDuration(description, result.getRunTime(description));
                }
            }
            putTestFailureTimestamp(result);
        }
    }

    private class TestComparator implements Comparator<Description> {
        public int compare(Description o1, Description o2) {
            // Always prefer new tests
            int result = fFailureTimestamps.get(o1).compareTo(fFailureTimestamps.get(o2));
            if (result != 0) {
                return result;
            }
            
            // Always prefer tests that have been run
            boolean o1New = fDurations.get(o1) == null;
            boolean o2New = fDurations.get(o2) == null;
            if (o1New || o2New) {
                if (o1New && o2New) {
                    return 0;
                }
                return o1New ? 1 : -1;
            }
            
            // Always prefer short tests
            return fDurations.get(o1).compareTo(fDurations.get(o2));
        }

        private Long getFailure(Description key) {
            return fFailureTimestamps.get(key.toString());
        }
    }

    /**
     * @return a listener that will update this history based on the test
     *         results reported.
     */
    public RunListener listener() {
        return new RememberingListener();
    }

    /**
     * @return a comparator that ranks tests based on the JUnit Max sorting
     *         rules, as described in the {@link MaxCore} class comment.
     */
    public Comparator<Description> testComparator() {
        return new TestComparator();
    }
}
