package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @deprecated Included for backwards compatibility with JUnit 4.4. Will be
 *             removed in the next major release. Please use
 *             {@link BlockJUnit4ClassRunner} in place of {@link JUnit4ClassRunner}.
 */
@Deprecated
public class MethodValidator {

    private final List<Throwable> errors = new ArrayList<Throwable>();

    private TestClass testClass;

    public MethodValidator(TestClass testClass) {
        
    }

    public void validateInstanceMethods() {
        
    }

    public void validateStaticMethods() {
        
    }

    public List<Throwable> validateMethodsForDefaultRunner() {
        
    }

    public void assertValid() throws InitializationError {
        
    }

    public void validateNoArgConstructor() {
        
    }

    private void validateTestMethods(Class<? extends Annotation> annotation,
            boolean isStatic) {
        
    }
}
