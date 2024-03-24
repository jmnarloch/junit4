package org.junit.internal.runners.statements;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

public class ExpectException extends Statement {
    private final Statement next;
    private final Class<? extends Throwable> expected;

    public ExpectException(Statement next, Class<? extends Throwable> expected) {
        
    }

    @Override
    public void evaluate() throws Exception {
        
    }
}