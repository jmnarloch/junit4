package org.junit.experimental.theories.internal;

import static java.util.Collections.emptyList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;
import org.junit.runners.model.TestClass;

/**
 * A potentially incomplete list of value assignments for a method's formal
 * parameters
 */
public class Assignments {
    private final List<PotentialAssignment> assigned;

    private final List<ParameterSignature> unassigned;

    private final TestClass clazz;

    private Assignments(List<PotentialAssignment> assigned,
            List<ParameterSignature> unassigned, TestClass clazz) {
        
    }

    /**
     * Returns a new assignment list for {@code testMethod}, with no params
     * assigned.
     */
    public static Assignments allUnassigned(Method testMethod,
            TestClass testClass) {
        
    }

    public boolean isComplete() {
        
    }

    public ParameterSignature nextUnassigned() {
        
    }

    public Assignments assignNext(PotentialAssignment source) {
        
    }

    public Object[] getActualValues(int start, int stop) 
            throws CouldNotGenerateValueException {
        
    }

    public List<PotentialAssignment> potentialsForNextUnassigned()
            throws Throwable {
        
    }

    private List<PotentialAssignment> generateAssignmentsFromTypeAlone(ParameterSignature unassigned) {
        
    }

    private ParameterSupplier getSupplier(ParameterSignature unassigned)
            throws Exception {
        
    }

    private ParameterSupplier buildParameterSupplierFromClass(
            Class<? extends ParameterSupplier> cls) throws Exception {
        
    }

    public Object[] getConstructorArguments()
            throws CouldNotGenerateValueException {
        
    }

    public Object[] getMethodArguments() throws CouldNotGenerateValueException {
        
    }

    public Object[] getAllArguments() throws CouldNotGenerateValueException {
        
    }

    private int getConstructorParameterCount() {
        
    }

    public Object[] getArgumentStrings(boolean nullsOk)
            throws CouldNotGenerateValueException {
        
    }
}