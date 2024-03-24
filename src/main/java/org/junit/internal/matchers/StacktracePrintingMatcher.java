package org.junit.internal.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import org.junit.internal.Throwables;

/**
 * A matcher that delegates to throwableMatcher and in addition appends the
 * stacktrace of the actual Throwable in case of a mismatch.
 */
public class StacktracePrintingMatcher<T extends Throwable> extends
        org.hamcrest.TypeSafeMatcher<T> {

    private final Matcher<T> throwableMatcher;

    public StacktracePrintingMatcher(Matcher<T> throwableMatcher) {
        
    }

    public void describeTo(Description description) {
        
    }

    @Override
    protected boolean matchesSafely(T item) {
        
    }

    @Override
    protected void describeMismatchSafely(T item, Description description) {
        
    }

    private String readStacktrace(Throwable throwable) {
        
    }

    @Factory
    public static <T extends Throwable> Matcher<T> isThrowable(
            Matcher<T> throwableMatcher) {
        
    }

    @Factory
    public static <T extends Exception> Matcher<T> isException(
            Matcher<T> exceptionMatcher) {
        
    }
}
