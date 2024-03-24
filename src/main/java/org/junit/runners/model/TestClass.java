package org.junit.runners.model;

import static java.lang.reflect.Modifier.isStatic;
import static org.junit.internal.MethodSorter.NAME_ASCENDING;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.internal.MethodSorter;

/**
 * Wraps a class to be run, providing method validation and annotation searching
 *
 * @since 4.5
 */
public class TestClass implements Annotatable {
    private static final FieldComparator FIELD_COMPARATOR = new FieldComparator();
    private static final MethodComparator METHOD_COMPARATOR = new MethodComparator();

    private final Class<?> clazz;
    private final Map<Class<? extends Annotation>, List<FrameworkMethod>> methodsForAnnotations;
    private final Map<Class<? extends Annotation>, List<FrameworkField>> fieldsForAnnotations;

    /**
     * Creates a {@code TestClass} wrapping {@code clazz}. Each time this
     * constructor executes, the class is scanned for annotations, which can be
     * an expensive process (we hope in future JDK's it will not be.) Therefore,
     * try to share instances of {@code TestClass} where possible.
     */
    public TestClass(Class<?> clazz) {
        
    }

    protected void scanAnnotatedMembers(Map<Class<? extends Annotation>, List<FrameworkMethod>> methodsForAnnotations, Map<Class<? extends Annotation>, List<FrameworkField>> fieldsForAnnotations) {
        
    }

    private static Field[] getSortedDeclaredFields(Class<?> clazz) {
        
    }

    protected static <T extends FrameworkMember<T>> void addToAnnotationLists(T member,
            Map<Class<? extends Annotation>, List<T>> map) {
        
    }

    private static <T extends FrameworkMember<T>> Map<Class<? extends Annotation>, List<T>>
            makeDeeplyUnmodifiable(Map<Class<? extends Annotation>, List<T>> source) {
        
    }

    /**
     * Returns, efficiently, all the non-overridden methods in this class and
     * its superclasses that are annotated}.
     * 
     * @since 4.12
     */
    public List<FrameworkMethod> getAnnotatedMethods() {
        
    }

    /**
     * Returns, efficiently, all the non-overridden methods in this class and
     * its superclasses that are annotated with {@code annotationClass}.
     */
    public List<FrameworkMethod> getAnnotatedMethods(
            Class<? extends Annotation> annotationClass) {
        
    }

    /**
     * Returns, efficiently, all the non-overridden fields in this class and its
     * superclasses that are annotated.
     * 
     * @since 4.12
     */
    public List<FrameworkField> getAnnotatedFields() {
        
    }

    /**
     * Returns, efficiently, all the non-overridden fields in this class and its
     * superclasses that are annotated with {@code annotationClass}.
     */
    public List<FrameworkField> getAnnotatedFields(
            Class<? extends Annotation> annotationClass) {
        
    }

    private <T> List<T> collectValues(Map<?, List<T>> map) {
        
    }

    private static <T> List<T> getAnnotatedMembers(Map<Class<? extends Annotation>, List<T>> map,
            Class<? extends Annotation> type, boolean fillIfAbsent) {
        
    }

    private static boolean runsTopToBottom(Class<? extends Annotation> annotation) {
        
    }

    private static List<Class<?>> getSuperClasses(Class<?> testClass) {
        
    }

    /**
     * Returns the underlying Java class.
     */
    public Class<?> getJavaClass() {
        
    }

    /**
     * Returns the class's name.
     */
    public String getName() {
        
    }

    /**
     * Returns the only public constructor in the class, or throws an {@code
     * AssertionError} if there are more or less than one.
     */

    public Constructor<?> getOnlyConstructor() {
        
    }

    /**
     * Returns the annotations on this class
     */
    public Annotation[] getAnnotations() {
        
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        
    }

    public <T> List<T> getAnnotatedFieldValues(Object test,
            Class<? extends Annotation> annotationClass, Class<T> valueClass) {
        
    }

    /**
     * Finds the fields annotated with the specified annotation and having the specified type,
     * retrieves the values and passes those to the specified consumer.
     *
     * @since 4.13
     */
    public <T> void collectAnnotatedFieldValues(Object test,
            Class<? extends Annotation> annotationClass, Class<T> valueClass,
            MemberValueConsumer<T> consumer) {
        
    }

    public <T> List<T> getAnnotatedMethodValues(Object test,
            Class<? extends Annotation> annotationClass, Class<T> valueClass) {
        
    }

    /**
     * Finds the methods annotated with the specified annotation and returning the specified type,
     * invokes it and pass the return value to the specified consumer.
     *
     * @since 4.13
     */
    public <T> void collectAnnotatedMethodValues(Object test,
            Class<? extends Annotation> annotationClass, Class<T> valueClass,
            MemberValueConsumer<T> consumer) {
        
    }

    public boolean isPublic() {
        
    }

    public boolean isANonStaticInnerClass() {
        
    }

    @Override
    public int hashCode() {
        
    }

    @Override
    public boolean equals(Object obj) {
        
    }

    /**
     * Compares two fields by its name.
     */
    private static class FieldComparator implements Comparator<Field> {
        public int compare(Field left, Field right) {
            
        }
    }

    /**
     * Compares two methods by its name.
     */
    private static class MethodComparator implements
            Comparator<FrameworkMethod> {
        public int compare(FrameworkMethod left, FrameworkMethod right) {
            
        }
    }
}
