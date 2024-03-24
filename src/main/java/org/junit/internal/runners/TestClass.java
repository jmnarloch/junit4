package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @deprecated Included for backwards compatibility with JUnit 4.4. Will be
 *             removed in the next major release. Please use
 *             {@link BlockJUnit4ClassRunner} in place of {@link JUnit4ClassRunner}.
 */
@Deprecated
public class TestClass {
    private final Class<?> klass;

    public TestClass(Class<?> klass) {
        
    }

    public List<Method> getTestMethods() {
        
    }

    List<Method> getBefores() {
        
    }

    List<Method> getAfters() {
        
    }

    public List<Method> getAnnotatedMethods(Class<? extends Annotation> annotationClass) {
        
    }

    private boolean runsTopToBottom(Class<? extends Annotation> annotation) {
        
    }

    private boolean isShadowed(Method method, List<Method> results) {
        
    }

    private boolean isShadowed(Method current, Method previous) {
        
    }

    private List<Class<?>> getSuperClasses(Class<?> testClass) {
        
    }

    public Constructor<?> getConstructor() throws SecurityException, NoSuchMethodException {
        
    }

    public Class<?> getJavaClass() {
        
    }

    public String getName() {
        
    }

}
