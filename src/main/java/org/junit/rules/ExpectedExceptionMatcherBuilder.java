package org.junit.rules;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.matchers.JUnitMatchers.isThrowable;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;

/**
 * Builds special matcher used by {@link ExpectedException}.
 */
class ExpectedExceptionMatcherBuilder {

    private final List<Matcher<?>> matchers = new ArrayList<Matcher<?>>();

    void add(Matcher<?> matcher) {
        
    }

    boolean expectsThrowable() {
        
    }

    Matcher<Throwable> build() {
        
    }

    private Matcher<Throwable> allOfTheMatchers() {
        
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private List<Matcher<? super Throwable>> castedMatchers() {
        
    }

    @SuppressWarnings("unchecked")
    private Matcher<Throwable> cast(Matcher<?> singleMatcher) {
        
    }
}
