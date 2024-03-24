package org.junit.internal;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Assert;

/**
 * Defines criteria for finding two items "equal enough". Concrete subclasses
 * may demand exact equality, or, for example, equality within a given delta.
 */
public abstract class ComparisonCriteria {
    /**
     * Asserts that two arrays are equal, according to the criteria defined by
     * the concrete subclass. If they are not, an {@link AssertionError} is
     * thrown with the given message. If <code>expecteds</code> and
     * <code>actuals</code> are <code>null</code>, they are considered equal.
     *
     * @param message the identifying message for the {@link AssertionError} (
     * <code>null</code> okay)
     * @param expecteds Object array or array of arrays (multi-dimensional array) with
     * expected values.
     * @param actuals Object array or array of arrays (multi-dimensional array) with
     * actual values
     */
    public void arrayEquals(String message, Object expecteds, Object actuals)
            throws ArrayComparisonFailure {
        
    }

    private void arrayEquals(String message, Object expecteds, Object actuals, boolean outer)
            throws ArrayComparisonFailure {
        
    }

    private static final Object END_OF_ARRAY_SENTINEL = objectWithToString("end of array");

    private Object getToStringableArrayElement(Object array, int length, int index) {
        
    }

    private static Object objectWithToString(final String string) {
        
    }

    private String componentTypeName(Class<?> arrayClass) {
        
    }

    private boolean isArray(Object expected) {
        
    }

    protected abstract void assertElementsEqual(Object expected, Object actual);
}
