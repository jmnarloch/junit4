package org.junit.runners.parameterized;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * A {@link BlockJUnit4ClassRunner} with parameters support. Parameters can be
 * injected via constructor or into annotated fields.
 */
public class BlockJUnit4ClassRunnerWithParameters extends
        BlockJUnit4ClassRunner {
    private enum InjectionType {
        CONSTRUCTOR, FIELD
    }

    private final Object[] parameters;

    private final String name;

    public BlockJUnit4ClassRunnerWithParameters(TestWithParameters test)
            throws InitializationError {
        
    }

    @Override
    public Object createTest() throws Exception {
        
    }

    private Object createTestUsingConstructorInjection() throws Exception {
        
    }

    private Object createTestUsingFieldInjection() throws Exception {
        
    }

    @Override
    protected String getName() {
        
    }

    @Override
    protected String testName(FrameworkMethod method) {
        
    }

    @Override
    protected void validateConstructor(List<Throwable> errors) {
        
    }

    @Override
    protected void validateFields(List<Throwable> errors) {
        
    }

    @Override
    protected Statement classBlock(RunNotifier notifier) {
        
    }

    private Statement withBeforeParams(Statement statement) {
        
    }

    private class RunBeforeParams extends RunBefores {
        RunBeforeParams(Statement next, List<FrameworkMethod> befores) {
            
        }

        @Override
        protected void invokeMethod(FrameworkMethod method) throws Throwable {
            
        }
    }

    private Statement withAfterParams(Statement statement) {
        
    }

    private class RunAfterParams extends RunAfters {
        RunAfterParams(Statement next, List<FrameworkMethod> afters) {
            
        }

        @Override
        protected void invokeMethod(FrameworkMethod method) throws Throwable {
            
        }
    }

    @Override
    protected Annotation[] getRunnerAnnotations() {
        
    }

    private List<FrameworkField> getAnnotatedFieldsByParameter() {
        
    }

    private InjectionType getInjectionType() {
        
    }

    private boolean fieldsAreAnnotated() {
        
    }
}
