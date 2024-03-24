package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Represents a field on a test class (currently used only for Rules in
 * {@link BlockJUnit4ClassRunner}, but custom runners can make other uses)
 *
 * @since 4.7
 */
public class FrameworkField extends FrameworkMember<FrameworkField> {
    private final Field field;

    /**
     * Returns a new {@code FrameworkField} for {@code field}.
     *
     * <p>Access relaxed to {@code public} since version 4.13.1.
     */
    public FrameworkField(Field field) {
        
    }

    @Override
    public String getName() {
        
    }

    public Annotation[] getAnnotations() {
        
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        
    }

    @Override
    public boolean isShadowedBy(FrameworkField otherMember) {
        
    }

    @Override
    boolean isBridgeMethod() { }

    @Override
    protected int getModifiers() {
        
    }

    /**
     * @return the underlying java Field
     */
    public Field getField() {
        
    }

    /**
     * @return the underlying Java Field type
     * @see java.lang.reflect.Field#getType()
     */
    @Override
    public Class<?> getType() {
        
    }
    
    @Override
    public Class<?> getDeclaringClass() {
        
    }

    /**
     * Attempts to retrieve the value of this field on {@code target}
     */
    public Object get(Object target) throws IllegalArgumentException, IllegalAccessException {
        
    }

    @Override
    public String toString() {
        
    }
}
