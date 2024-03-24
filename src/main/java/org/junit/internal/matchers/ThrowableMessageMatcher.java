package org.junit.internal.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ThrowableMessageMatcher<T extends Throwable> extends
        TypeSafeMatcher<T> {

    private final Matcher<String> matcher;

    public ThrowableMessageMatcher(Matcher<String> matcher) {
        
    }

    public void describeTo(Description description) {
        
    }

    @Override
    protected boolean matchesSafely(T item) {
        
    }

    @Override
    protected void describeMismatchSafely(T item, Description description) {
        
    }

    @Factory
    public static <T extends Throwable> Matcher<T> hasMessage(final Matcher<String> matcher) {
        
    }
}