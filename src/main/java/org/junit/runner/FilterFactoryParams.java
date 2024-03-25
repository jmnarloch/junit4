package org.junit.runner;

public final class FilterFactoryParams {
    private final Description topLevelDescription;
    private final String args;

    public FilterFactoryParams(Description topLevelDescription, String args) {
        this.topLevelDescription = topLevelDescription;
        this.args = args;
    }

    public String getArgs() {
        return args;
    }

    public Description getTopLevelDescription() {
        return topLevelDescription;
    }
}
