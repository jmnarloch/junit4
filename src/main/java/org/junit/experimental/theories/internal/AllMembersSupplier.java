package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

/**
 * Supplies Theory parameters based on all public members of the target class.
 */
public class AllMembersSupplier extends ParameterSupplier {
    static class MethodParameterValue extends PotentialAssignment {
        private final FrameworkMethod method;

        private MethodParameterValue(FrameworkMethod dataPointMethod) {
            
        }

        @Override
        public Object getValue() throws CouldNotGenerateValueException {
            
        }

        @Override
        public String getDescription() throws CouldNotGenerateValueException {
            
        }
    }
    
    private final TestClass clazz;

    /**
     * Constructs a new supplier for {@code type}
     */
    public AllMembersSupplier(TestClass type) {
        
    }

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        
    }

    private void addMultiPointMethods(ParameterSignature sig, List<PotentialAssignment> list) throws Throwable {
        
    }

    private void addSinglePointMethods(ParameterSignature sig, List<PotentialAssignment> list) {
        
    }
    
    private void addMultiPointFields(ParameterSignature sig, List<PotentialAssignment> list) {
        
    }

    private void addSinglePointFields(ParameterSignature sig, List<PotentialAssignment> list) {
        
    }
    
    private void addDataPointsValues(Class<?> type, ParameterSignature sig, String name, 
            List<PotentialAssignment> list, Object value) {
        
    }

    private void addArrayValues(ParameterSignature sig, String name, List<PotentialAssignment> list, Object array) {
        
    }
    
    private void addIterableValues(ParameterSignature sig, String name, List<PotentialAssignment> list, Iterable<?> iterable) {
        
    }

    private Object getStaticFieldValue(final Field field) {
        
    }
    
    private static boolean isAssignableToAnyOf(Class<?>[] typeArray, Object target) {
        
    }

    protected Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature sig) {
        
    }
    
    protected Collection<Field> getSingleDataPointFields(ParameterSignature sig) {
        
    }
    
    protected Collection<Field> getDataPointsFields(ParameterSignature sig) {
        
    }
    
    protected Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature sig) {
        
    }

}