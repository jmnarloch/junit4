package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Runs a collection of rules on a statement.
 *
 * @since 4.9
 */
public class RunRules extends Statement {
    private final Statement statement;

    public RunRules(Statement base, Iterable<TestRule> rules, Description description) {
        
    }

    @Override
    public void evaluate() throws Throwable {
        
    }

    private static Statement applyAll(Statement result, Iterable<TestRule> rules,
            Description description) {
        
    }
}
