package org.junit.validator;

import static java.util.Collections.singletonList;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.runners.model.Annotatable;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

/**
 * An {@code AnnotationsValidator} validates all annotations of a test class,
 * including its annotated fields and methods.
 * 
 * @since 4.12
 */
public final class AnnotationsValidator implements TestClassValidator {
    private static final List<AnnotatableValidator<?>> VALIDATORS = Arrays.<AnnotatableValidator<?>>asList(
            new ClassValidator(), new MethodValidator(), new FieldValidator());

    /**
     * Validate all annotations of the specified test class that are be
     * annotated with {@link ValidateWith}.
     * 
     * @param testClass
     *            the {@link TestClass} that is validated.
     * @return the errors found by the validator.
     */
    public List<Exception> validateTestClass(TestClass testClass) {
        
    }

    private abstract static class AnnotatableValidator<T extends Annotatable> {
        private static final AnnotationValidatorFactory ANNOTATION_VALIDATOR_FACTORY = new AnnotationValidatorFactory();

        abstract Iterable<T> getAnnotatablesForTestClass(TestClass testClass);

        abstract List<Exception> validateAnnotatable(
                AnnotationValidator validator, T annotatable);

        public List<Exception> validateTestClass(TestClass testClass) {
            
        }

        private List<Exception> validateAnnotatable(T annotatable) {
            
        }
    }

    private static class ClassValidator extends AnnotatableValidator<TestClass> {
        @Override
        Iterable<TestClass> getAnnotatablesForTestClass(TestClass testClass) {
            
        }

        @Override
        List<Exception> validateAnnotatable(
                AnnotationValidator validator, TestClass testClass) {
            
        }
    }

    private static class MethodValidator extends
            AnnotatableValidator<FrameworkMethod> {
        @Override
        Iterable<FrameworkMethod> getAnnotatablesForTestClass(
                TestClass testClass) {
            
        }

        @Override
        List<Exception> validateAnnotatable(
                AnnotationValidator validator, FrameworkMethod method) {
            
        }
    }

    private static class FieldValidator extends
            AnnotatableValidator<FrameworkField> {
        @Override
        Iterable<FrameworkField> getAnnotatablesForTestClass(TestClass testClass) {
            
        }

        @Override
        List<Exception> validateAnnotatable(
                AnnotationValidator validator, FrameworkField field) {
            
        }
    }
}
