package org.junit.internal;

import org.junit.Assert;

public class InexactComparisonCriteria extends ComparisonCriteria {
    public Object fDelta;

    public InexactComparisonCriteria(double delta) {
        
    }

    public InexactComparisonCriteria(float delta) {
        
    }

    @Override
    protected void assertElementsEqual(Object expected, Object actual) {
        
    }
}