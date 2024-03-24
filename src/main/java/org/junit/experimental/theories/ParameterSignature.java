package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterSignature {
    
    private static final Map<Class<?>, Class<?>> CONVERTABLE_TYPES_MAP = buildConvertableTypesMap();
    
    private static Map<Class<?>, Class<?>> buildConvertableTypesMap() {
        
    }
    
    private static <T> void putSymmetrically(Map<T, T> map, T a, T b) {
        
    }
    
    public static ArrayList<ParameterSignature> signatures(Method method) {
        
    }

    public static List<ParameterSignature> signatures(Constructor<?> constructor) {
        
    }

    private static ArrayList<ParameterSignature> signatures(
            Class<?>[] parameterTypes, Annotation[][] parameterAnnotations) {
        
    }

    private final Class<?> type;

    private final Annotation[] annotations;

    private ParameterSignature(Class<?> type, Annotation[] annotations) {
        
    }

    public boolean canAcceptValue(Object candidate) {
        
    }

    public boolean canAcceptType(Class<?> candidate) {
        
    }
    
    public boolean canPotentiallyAcceptType(Class<?> candidate) {
        
    }

    private boolean isAssignableViaTypeConversion(Class<?> targetType, Class<?> candidate) {
        
    }

    public Class<?> getType() {
        
    }

    public List<Annotation> getAnnotations() {
        
    }

    public boolean hasAnnotation(Class<? extends Annotation> type) {
        
    }

    public <T extends Annotation> T findDeepAnnotation(Class<T> annotationType) {
        
    }

    private <T extends Annotation> T findDeepAnnotation(
            Annotation[] annotations, Class<T> annotationType, int depth) {
        
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        
    }
}