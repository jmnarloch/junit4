package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Test.None;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @deprecated Included for backwards compatibility with JUnit 4.4. Will be
 *             removed in the next major release. Please use
 *             {@link BlockJUnit4ClassRunner} in place of {@link JUnit4ClassRunner}.
 */
@Deprecated
public class TestMethod {
    private final Method method;
    private TestClass testClass;

    public TestMethod(Method method, TestClass testClass) {
        
    }

    public boolean isIgnored() {
        
    }

    public long getTimeout() {
        
    }

    protected Class<? extends Throwable> getExpectedException() {
        
    }

    boolean isUnexpected(Throwable exception) {
        
    }

    boolean expectsException() {
        
    }

    List<Method> getBefores() {
        
    }

    List<Method> getAfters() {
        
    }

    public void invoke(Object test) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        
    }

}
