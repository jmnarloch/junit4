package org.junit.internal.builders;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class AllDefaultPossibilitiesBuilder extends RunnerBuilder {
    private final boolean canUseSuiteMethod;

    /**
     * @since 4.13
     */
    public AllDefaultPossibilitiesBuilder() {
        
    }

    /**
     * @deprecated used {@link #AllDefaultPossibilitiesBuilder()}.
     */
    @Deprecated
    public AllDefaultPossibilitiesBuilder(boolean canUseSuiteMethod) {
        
    }

    @Override
    public Runner runnerForClass(Class<?> testClass) throws Throwable {
        
    }

    protected JUnit4Builder junit4Builder() {
        
    }

    protected JUnit3Builder junit3Builder() {
        
    }

    protected AnnotatedBuilder annotatedBuilder() {
        
    }

    protected IgnoredBuilder ignoredBuilder() {
        
    }

    protected RunnerBuilder suiteMethodBuilder() {
        
    }
}