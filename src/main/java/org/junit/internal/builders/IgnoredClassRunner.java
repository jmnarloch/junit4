package org.junit.internal.builders;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class IgnoredClassRunner extends Runner {
    private final Class<?> clazz;

    public IgnoredClassRunner(Class<?> testClass) {
        
    }

    @Override
    public void run(RunNotifier notifier) {
        
    }

    @Override
    public Description getDescription() {
        
    }
}