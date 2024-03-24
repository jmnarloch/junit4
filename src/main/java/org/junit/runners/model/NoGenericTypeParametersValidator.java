package org.junit.runners.model;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

class NoGenericTypeParametersValidator {
    private final Method method;

    NoGenericTypeParametersValidator(Method method) {
        
    }

    void validate(List<Throwable> errors) {
        
    }

    private void validateNoTypeParameterOnType(Type type, List<Throwable> errors) {
        
    }

    private void validateNoTypeParameterOnParameterizedType(ParameterizedType parameterized,
            List<Throwable> errors) {
        
    }

    private void validateNoTypeParameterOnWildcardType(WildcardType wildcard,
            List<Throwable> errors) {
        
    }

    private void validateNoTypeParameterOnGenericArrayType(
            GenericArrayType arrayType, List<Throwable> errors) {
        
    }
}