package org.junit.experimental.theories.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class SpecificDataPointsSupplier extends AllMembersSupplier {

    public SpecificDataPointsSupplier(TestClass testClass) {
        
    }
    
    @Override
    protected Collection<Field> getSingleDataPointFields(ParameterSignature sig) {
        
    }
    
    @Override
    protected Collection<Field> getDataPointsFields(ParameterSignature sig) {
        
    }
    
    @Override
    protected Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature sig) {
        
    }
    
    @Override
    protected Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature sig) {
        
    }

}
