package org.junit.runners.parameterized;

import static java.util.Collections.unmodifiableList;
import static org.junit.internal.Checks.notNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.runners.model.TestClass;

/**
 * A {@code TestWithParameters} keeps the data together that are needed for
 * creating a runner for a single data set of a parameterized test. It has a
 * name, the test class and a list of parameters.
 * 
 * @since 4.12
 */
public class TestWithParameters {
    private final String name;

    private final TestClass testClass;

    private final List<Object> parameters;

    public TestWithParameters(String name, TestClass testClass,
            List<Object> parameters) {
        
    }

    public String getName() {
        
    }

    public TestClass getTestClass() {
        
    }

    public List<Object> getParameters() {
        
    }

    @Override
    public int hashCode() {
        
    }

    @Override
    public boolean equals(Object obj) {
        
    }

    @Override
    public String toString() {
        
    }
}
