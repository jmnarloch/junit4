package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import junit.extensions.TestDecorator;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class JUnit38ClassRunner extends Runner implements Filterable, Orderable {
    private static final class OldTestClassAdaptingListener implements
            TestListener {
        private final RunNotifier notifier;

        private OldTestClassAdaptingListener(RunNotifier notifier) {
            
        }

        public void endTest(Test test) {
            
        }

        public void startTest(Test test) {
            
        }

        // Implement junit.framework.TestListener
        public void addError(Test test, Throwable e) {
            
        }

        private Description asDescription(Test test) {
            
        }

        private Class<? extends Test> getEffectiveClass(Test test) {
            
        }

        private String getName(Test test) {
            
        }

        public void addFailure(Test test, AssertionFailedError t) {
            
        }
    }

    private volatile Test test;

    public JUnit38ClassRunner(Class<?> klass) {
        
    }

    public JUnit38ClassRunner(Test test) {
        
    }

    @Override
    public void run(RunNotifier notifier) {
        
    }

    public TestListener createAdaptingListener(final RunNotifier notifier) {
        
    }

    @Override
    public Description getDescription() {
        
    }

    private static Description makeDescription(Test test) {
        
    }

    /**
     * Get the annotations associated with given TestCase.
     * @param test the TestCase.
     */
    private static Annotation[] getAnnotations(TestCase test) {
        
    }

    private static String createSuiteDescription(TestSuite ts) {
        
    }

    public void filter(Filter filter) throws NoTestsRemainException {
        
    }

    public void sort(Sorter sorter) {
        
    }

    /**
     * {@inheritDoc}
     *
     * @since 4.13
     */
    public void order(Orderer orderer) throws InvalidOrderingException {
        
    }

    private void setTest(Test test) {
        
    }

    private Test getTest() {
        
    }
}
