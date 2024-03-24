package org.junit.runners.model;

import java.util.List;

/**
 * Thrown by {@link org.junit.runner.Runner}s in case the class under test is not valid.
 * <p>
 * Its message conveniently lists all of the validation errors.
 *
 * @since 4.13
 */
public class InvalidTestClassError extends InitializationError {
    private static final long serialVersionUID = 1L;

    private final String message;

    public InvalidTestClassError(Class<?> offendingTestClass, List<Throwable> validationErrors) {
        
    }

    private static String createMessage(Class<?> testClass, List<Throwable> validationErrors) {
        
    }

    /**
     * @return a message with a list of all of the validation errors
     */
    @Override
    public String getMessage() {
        
    }
}
