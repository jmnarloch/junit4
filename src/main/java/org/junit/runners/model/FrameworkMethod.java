package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.internal.runners.model.ReflectiveCallable;

/**
 * Represents a method on a test class to be invoked at the appropriate point in
 * test execution. These methods are usually marked with an annotation (such as
 * {@code @Test}, {@code @Before}, {@code @After}, {@code @BeforeClass},
 * {@code @AfterClass}, etc.)
 *
 * @since 4.5
 */
public class FrameworkMethod extends FrameworkMember<FrameworkMethod> {
    private final Method method;

    /**
     * Returns a new {@code FrameworkMethod} for {@code method}
     */
    public FrameworkMethod(Method method) {
        
    }

    /**
     * Returns the underlying Java method
     */
    public Method getMethod() {
        
    }

    /**
     * Returns the result of invoking this method on {@code target} with
     * parameters {@code params}. {@link InvocationTargetException}s thrown are
     * unwrapped, and their causes rethrown.
     */
    public Object invokeExplosively(final Object target, final Object... params)
            throws Throwable {
        
    }

    /**
     * Returns the method's name
     */
    @Override
    public String getName() {
        
    }

    /**
     * Adds to {@code errors} if this method:
     * <ul>
     * <li>is not public, or
     * <li>takes parameters, or
     * <li>returns something other than void, or
     * <li>is static (given {@code isStatic is false}), or
     * <li>is not static (given {@code isStatic is true}).
     * </ul>
     */
    public void validatePublicVoidNoArg(boolean isStatic, List<Throwable> errors) {
        
    }


    /**
     * Adds to {@code errors} if this method:
     * <ul>
     * <li>is not public, or
     * <li>returns something other than void, or
     * <li>is static (given {@code isStatic is false}), or
     * <li>is not static (given {@code isStatic is true}).
     * </ul>
     */
    public void validatePublicVoid(boolean isStatic, List<Throwable> errors) {
        
    }

    @Override
    protected int getModifiers() {
        
    }

    /**
     * Returns the return type of the method
     */
    public Class<?> getReturnType() {
        
    }

    /**
     * Returns the return type of the method
     */
    @Override
    public Class<?> getType() {
        
    }

    /**
     * Returns the class where the method is actually declared
     */
    @Override
    public Class<?> getDeclaringClass() {
        
    }

    public void validateNoTypeParametersOnArgs(List<Throwable> errors) {
        
    }

    @Override
    public boolean isShadowedBy(FrameworkMethod other) {
        
    }

    @Override
    boolean isBridgeMethod() {
        
    }

    @Override
    public boolean equals(Object obj) {
        
    }

    @Override
    public int hashCode() {
        
    }

    /**
     * Returns true if this is a no-arg method that returns a value assignable
     * to {@code type}
     *
     * @deprecated This is used only by the Theories runner, and does not
     *             use all the generic type info that it ought to. It will be replaced
     *             with a forthcoming ParameterSignature#canAcceptResultOf(FrameworkMethod)
     *             once Theories moves to junit-contrib.
     */
    @Deprecated
    public boolean producesType(Type type) {
        
    }

    private Class<?>[] getParameterTypes() {
        
    }

    /**
     * Returns the annotations on this method
     */
    public Annotation[] getAnnotations() {
        
    }

    /**
     * Returns the annotation of type {@code annotationType} on this method, if
     * one exists.
     */
    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        
    }

    @Override
    public String toString() {
        
    }
}
