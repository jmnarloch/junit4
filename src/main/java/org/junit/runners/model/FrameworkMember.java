package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Parent class for {@link FrameworkField} and {@link FrameworkMethod}
 *
 * @since 4.7
 */
public abstract class FrameworkMember<T extends FrameworkMember<T>> implements
        Annotatable {
    abstract boolean isShadowedBy(T otherMember);

    T handlePossibleBridgeMethod(List<T> members) {
        if (!isBridgeMethod()) {
            return this;
        }
        for (T each : members) {
            if (each.isShadowedBy(this)) {
                return this;
            }
        }
        members.add(this);
        return this;
    }

    abstract boolean isBridgeMethod();

    protected abstract int getModifiers();

    /**
     * Returns true if this member is static, false if not.
     */
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    /**
     * Returns true if this member is public, false if not.
     */
    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public abstract String getName();

    public abstract Class<?> getType();

    public abstract Class<?> getDeclaringClass();
}
