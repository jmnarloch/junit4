package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @deprecated Included for backwards compatibility with JUnit 4.4. Will be
 *             removed in the next major release. Please use
 *             {@link BlockJUnit4ClassRunner} in place of {@link JUnit4ClassRunner}.
 */
@Deprecated
public class JUnit4ClassRunner extends Runner implements Filterable, Sortable {
    private final List<Method> testMethods;
    private TestClass testClass;

    public JUnit4ClassRunner(Class<?> klass) throws InitializationError {
        
    }

    protected List<Method> getTestMethods() {
        
    }

    protected void validate() throws InitializationError {
        
    }

    @Override
    public void run(final RunNotifier notifier) {
        
    }

    protected void runMethods(final RunNotifier notifier) {
        
    }

    @Override
    public Description getDescription() {
        
    }

    protected Annotation[] classAnnotations() {
        
    }

    protected String getName() {
        
    }

    protected Object createTest() throws Exception {
        
    }

    protected void invokeTestMethod(Method method, RunNotifier notifier) {
        
    }

    private void testAborted(RunNotifier notifier, Description description,
            Throwable e) {
        
    }

    protected TestMethod wrapMethod(Method method) {
        
    }

    protected String testName(Method method) {
        
    }

    protected Description methodDescription(Method method) {
        
    }

    protected Annotation[] testAnnotations(Method method) {
        
    }

    public void filter(Filter filter) throws NoTestsRemainException {
        
    }

    public void sort(final Sorter sorter) {
        
    }

    protected TestClass getTestClass() {
        
    }
}