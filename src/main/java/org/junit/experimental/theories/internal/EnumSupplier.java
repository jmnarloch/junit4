package org.junit.experimental.theories.internal;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class EnumSupplier extends ParameterSupplier {

    private Class<?> enumType;

    public EnumSupplier(Class<?> enumType) {
        
    }

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
        
    }

}
