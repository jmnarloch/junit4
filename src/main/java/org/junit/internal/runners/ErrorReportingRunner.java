package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InvalidTestClassError;
import org.junit.runners.model.InitializationError;

import static java.util.Collections.singletonList;

public class ErrorReportingRunner extends Runner {
    private final List<Throwable> causes;

    private final String classNames;

    public ErrorReportingRunner(Class<?> testClass, Throwable cause) {
        
    }
    
    public ErrorReportingRunner(Throwable cause, Class<?>... testClasses) {
        
    }
    
    @Override
    public Description getDescription() {
        
    }

    @Override
    public void run(RunNotifier notifier) {
        
    }

    private String getClassNames(Class<?>... testClasses) {
        
    }

    @SuppressWarnings("deprecation")
    private List<Throwable> getCauses(Throwable cause) {
        
    }

    private Description describeCause() {
        
    }

    private void runCause(Throwable child, RunNotifier notifier) {
        
    }
}
