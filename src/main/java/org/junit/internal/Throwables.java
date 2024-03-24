package org.junit.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Miscellaneous functions dealing with {@code Throwable}.
 *
 * @author kcooney@google.com (Kevin Cooney)
 * @since 4.12
 */
public final class Throwables {

    private Throwables() { }

    /**
     * Rethrows the given {@code Throwable}, allowing the caller to
     * declare that it throws {@code Exception}. This is useful when
     * your callers have nothing reasonable they can do when a
     * {@code Throwable} is thrown. This is declared to return {@code Exception}
     * so it can be used in a {@code throw} clause:
     * <pre>
     * try {
     *   doSomething();
     * } catch (Throwable e} {
     *   throw Throwables.rethrowAsException(e);
     * }
     * doSomethingLater();
     * </pre>
     *
     * @param e exception to rethrow
     * @return does not return anything
     * @since 4.12
     */
    public static Exception rethrowAsException(Throwable e) throws Exception {
         // we never get here
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void rethrow(Throwable e) throws T {
        
    }

    /**
     * Returns the stacktrace of the given Throwable as a String.
     *
     * @since 4.13
     */
    public static String getStacktrace(Throwable exception) {
        
    }

    /**
     * Gets a trimmed version of the stack trace of the given exception. Stack trace
     * elements that are below the test method are filtered out.
     *
     * @return a trimmed stack trace, or the original trace if trimming wasn't possible
     */
    public static String getTrimmedStackTrace(Throwable exception) {
        
    }

    private static List<String> getTrimmedStackTraceLines(Throwable exception) {
        
    }

    private static final Method getSuppressed = initGetSuppressed();

    private static Method initGetSuppressed() {
        
    }

    private static boolean hasSuppressed(Throwable exception) {
        
    }

    private static List<String> getCauseStackTraceLines(Throwable exception) {
        
    }

    private static String getFullStackTrace(Throwable exception) {
        
    }

    private static void appendStackTraceLines(
            List<String> stackTraceLines, StringBuilder destBuilder) {
        
    }

    private static <T> List<T> asReversedList(final List<T> list) {
        
    }

    private enum State {
        PROCESSING_OTHER_CODE {
            @Override public State processLine(String methodName) {
                
            }
        },
        PROCESSING_TEST_FRAMEWORK_CODE {
            @Override public State processLine(String methodName) {
                
            } 
        },
        PROCESSING_REFLECTION_CODE {
            @Override public State processLine(String methodName) {
                
            } 
        },
        DONE {
            @Override public State processLine(String methodName) {
                
            } 
        };

        /** Processes a stack trace element method name, possibly moving to a new state. */
        protected abstract State processLine(String methodName);
        
        /** Processes a stack trace element, possibly moving to a new state. */
        public final State processStackTraceElement(StackTraceElement element) {
            
        }
    }

    private static final String[] TEST_FRAMEWORK_METHOD_NAME_PREFIXES = {
        "org.junit.runner.",
        "org.junit.runners.",
        "org.junit.experimental.runners.",
        "org.junit.internal.",
        "junit.extensions",
        "junit.framework",
        "junit.runner",
        "junit.textui",
    };

    private static final String[] TEST_FRAMEWORK_TEST_METHOD_NAME_PREFIXES = {
        "org.junit.internal.StackTracesTest",
    };

    private static boolean isTestFrameworkMethod(String methodName) {
        
    }
    
    private static final String[] REFLECTION_METHOD_NAME_PREFIXES = {
        "sun.reflect.",
        "java.lang.reflect.",
        "jdk.internal.reflect.",
        "org.junit.rules.RunRules.<init>(",
        "org.junit.rules.RunRules.applyAll(", // calls TestRules
        "org.junit.runners.RuleContainer.apply(", // calls MethodRules & TestRules
        "junit.framework.TestCase.runBare(", // runBare() directly calls setUp() and tearDown()
   };
    
    private static boolean isReflectionMethod(String methodName) {
        
    }

    private static boolean isMatchingMethod(String methodName, String[] methodNamePrefixes) {
        
    }
}
