package org.junit.internal.matchers;

import java.lang.reflect.Method;

import org.hamcrest.BaseMatcher;
import org.junit.internal.MethodSorter;

/**
 * Convenient base class for Matchers that require a non-null value of a specific type.
 * This simply implements the null check, checks the type and then casts.
 *
 * @author Joe Walnes
 * @deprecated Please use {@link org.hamcrest.TypeSafeMatcher}.
 */
@Deprecated
public abstract class TypeSafeMatcher<T> extends BaseMatcher<T> {

    private Class<?> expectedType;

    /**
     * Subclasses should implement this. The item will already have been checked for
     * the specific type and will never be null.
     */
    public abstract boolean matchesSafely(T item);

    protected TypeSafeMatcher() {
        
    }

    private static Class<?> findExpectedType(Class<?> fromClass) {
        
    }

    private static boolean isMatchesSafelyMethod(Method method) {
        
    }

    protected TypeSafeMatcher(Class<T> expectedType) {
        
    }

    /**
     * Method made final to prevent accidental override.
     * If you need to override this, there's no point on extending TypeSafeMatcher.
     * Instead, extend the {@link BaseMatcher}.
     */
    @SuppressWarnings({"unchecked"})
    public final boolean matches(Object item) {
        
    }
}
