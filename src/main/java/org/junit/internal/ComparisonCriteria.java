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
        arrayEquals(message, expecteds, actuals, true);
    }

    private void arrayEquals(String message, Object expecteds, Object actuals, boolean outer)
            throws ArrayComparisonFailure {
        if (expecteds == actuals) {
            return;
        }
        String header = message == null ? "" : message + ": ";
        if (expecteds == null) {
            Assert.fail(header + "expected array was null");
        }
        if (actuals == null) {
            Assert.fail(header + "actual array was null");
        }
        int actualsLength = Array.getLength(actuals);
        int expectedsLength = Array.getLength(expecteds);
        int prefixLength = Math.min(actualsLength, expectedsLength);
        for (int i = 0; i < prefixLength; i++) {
            Object expected = Array.get(expecteds, i);
            Object actual = Array.get(actuals, i);
            if (isArray(expected) && isArray(actual)) {
                new ComparisonCriteria().arrayEquals(header + "arrays first differed at element "
                + i + "; ", expected, actual, false);
            }
            if (isArray(expected) || isArray(actual)) {
                assertArraysSameLength(expected, actual);
            } else {
                try {
                    assertElementsEqual(expected, actual);
                } catch (ArrayComparisonFailure e) {
                    e.addDimension(i);
                    throw e;
                } catch (AssertionError e) {
                    throw new ArrayComparisonFailure(header, e, i);
                }
            }
        }
        if (prefixLength != expectedsLength) {
            Object expected = getToStringableArrayElement(expecteds, expectedsLength, prefixLength);
            if (expected != END_OF_ARRAY_SENTINEL) {
                Assert.fail(header + "actual array shorter then expected array. "
                + "Expected array was " + this.<Object>arrayToString(expecteds) + " "
                + ", actual array " + this.<Object>arrayToString(actuals));
            }
        }
        if (prefixLength != actualsLength) {
            Object actual = getToStringableArrayElement(actuals, actualsLength, prefixLength);
            if (actual != END_OF_ARRAY_SENTINEL) {
                Assert.fail(header + "actual array longer then expected array. "
                + "Expected array was " + this.<Object>arrayToString(expecteds) + " "
                + ", actual array " + this.<Object>arrayToString(actuals));
            }
        }
    }

    private static final Object END_OF_ARRAY_SENTINEL = objectWithToString("end of array");

    private Object getToStringableArrayElement(Object array, int length, int index) {
        if (index < length) {
            Object element = Array.get(array, index);
            if (isArray(element)) {
                return objectWithToString(componentTypeName(element.getClass()) + "[" + Array.getLength(element) + "]");
            } else {
                return element;
            }
        } else {
            return END_OF_ARRAY_SENTINEL;
        }
    }

    private static Object objectWithToString(final String string) {
        return new Object() {
            @Override
            public String toString() {
                return string;
            }
        };
    }

    private String componentTypeName(Class<?> arrayClass) {
        Class<?> componentType = arrayClass.getComponentType();
        if (componentType.isArray()) {
            return componentTypeName(componentType) + "[]";
        } else {
            return componentType.getName();
        }
    }

    private boolean isArray(Object expected) {
        return expected != null && expected.getClass().isArray();
    }

    protected abstract void assertElementsEqual(Object expected, Object actual);
}
