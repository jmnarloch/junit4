package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ParameterizedAssertionError extends AssertionError {
    private static final long serialVersionUID = 1L;

    public ParameterizedAssertionError(Throwable targetException,
            String methodName, Object... params) {
        
    }

    @Override
    public boolean equals(Object obj) {
        
    }

    @Override
    public int hashCode() {
        
    }

    public static String join(String delimiter, Object... params) {
        
    }

    public static String join(String delimiter, Collection<Object> values) {
        
    }

    private static String stringValueOf(Object next) {
        
    }
}