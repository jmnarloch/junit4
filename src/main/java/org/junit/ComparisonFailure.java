package org.junit;

/**
 * Thrown when an {@link org.junit.Assert#assertEquals(Object, Object) assertEquals(String, String)} fails.
 * Create and throw a <code>ComparisonFailure</code> manually if you want to show users the
 * difference between two complex strings.
 * <p/>
 * Inspired by a patch from Alex Chaffee (alex@purpletech.com)
 *
 * @since 4.0
 */
public class ComparisonFailure extends AssertionError {
    /**
     * The maximum length for expected and actual strings. If it is exceeded, the strings should be shortened.
     *
     * @see ComparisonCompactor
     */
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1L;

    /*
     * We have to use the f prefix until the next major release to ensure
     * serialization compatibility. 
     * See https://github.com/junit-team/junit4/issues/976
     */
    private String fExpected;
    private String fActual;

    /**
     * Constructs a comparison failure.
     *
     * @param message the identifying message or null
     * @param expected the expected string value
     * @param actual the actual string value
     */
    public ComparisonFailure(String message, String expected, String actual) {
        
    }

    /**
     * Returns "..." in place of common prefix and "..." in place of common suffix between expected and actual.
     *
     * @see Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        
    }

    /**
     * Returns the actual string value
     *
     * @return the actual string value
     */
    public String getActual() {
        
    }

    /**
     * Returns the expected string value
     *
     * @return the expected string value
     */
    public String getExpected() {
        
    }

    private static class ComparisonCompactor {
        private static final String ELLIPSIS = "...";
        private static final String DIFF_END = "]";
        private static final String DIFF_START = "[";

        /**
         * The maximum length for <code>expected</code> and <code>actual</code> strings to show. When
         * <code>contextLength</code> is exceeded, the Strings are shortened.
         */
        private final int contextLength;
        private final String expected;
        private final String actual;

        /**
         * @param contextLength the maximum length of context surrounding the difference between the compared strings.
         * When context length is exceeded, the prefixes and suffixes are compacted.
         * @param expected the expected string value
         * @param actual the actual string value
         */
        public ComparisonCompactor(int contextLength, String expected, String actual) {
            
        }

        public String compact(String message) {
            
        }

        private String sharedPrefix() {
            
        }

        private String sharedSuffix(String prefix) {
            
        }

        private class DiffExtractor {
            private final String sharedPrefix;
            private final String sharedSuffix;

            /**
             * Can not be instantiated outside {@link org.junit.ComparisonFailure.ComparisonCompactor}.
             */
            private DiffExtractor() {
                
            }

            public String expectedDiff() {
                
            }

            public String actualDiff() {
                
            }

            public String compactPrefix() {
                
            }

            public String compactSuffix() {
                
            }

            private String extractDiff(String source) {
                
            }
        }
    }
}
