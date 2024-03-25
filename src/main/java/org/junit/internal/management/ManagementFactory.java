package org.junit.internal.management;

import org.junit.internal.Classes;

import java.lang.reflect.InvocationTargetException;

/**
 * Reflective wrapper around {@link java.lang.management.ManagementFactory}
 */
public class ManagementFactory {
  private static final class FactoryHolder {
    private static final Class<?> MANAGEMENT_FACTORY_CLASS;

    static {
      Class<?> managementFactoryClass = null;
      try {
        managementFactoryClass = Classes.getClass("java.lang.management.ManagementFactory");
      } catch (ClassNotFoundException e) {
        // do nothing, managementFactoryClass will be none on failure
      }
      MANAGEMENT_FACTORY_CLASS = managementFactoryClass;
    }

    static Object getBeanObject(String methodName) {
            if (MANAGEMENT_FACTORY_CLASS == null) {
                return null;
            }
            
            try {
                return MANAGEMENT_FACTORY_CLASS.getMethod(methodName).invoke(null);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e) {
            } catch (NoSuchMethodException e) {
            } catch (SecurityException e) {
            } catch (InvocationTargetException e) {
            }
            return null;
        }
  }

  private static final class RuntimeHolder {
    private static final RuntimeMXBean RUNTIME_MX_BEAN =
        getBean(FactoryHolder.getBeanObject("getRuntimeMXBean"));

    private static final RuntimeMXBean getBean(Object runtimeMxBean) {
            if (runtimeMxBean == null || RuntimeMXBean.class.isInstance(runtimeMxBean)) {
                return RuntimeMXBean.class.cast(runtimeMxBean);
            }
            return null;
        }
  }

  private static final class ThreadHolder {
    private static final ThreadMXBean THREAD_MX_BEAN =
        getBean(FactoryHolder.getBeanObject("getThreadMXBean"));

    private static final ThreadMXBean getBean(Object threadMxBean) {
            if (threadMxBean == null || threadMxBean.getClass() != Classes.getClass("java.lang.management.ThreadMXBean")) {
                return null;
            }
            return (ThreadMXBean) threadMxBean;
        }
  }

  /**
   * @see java.lang.management.ManagementFactory#getRuntimeMXBean()
   */
  public static RuntimeMXBean getRuntimeMXBean() {
        return RuntimeHolder.RUNTIME_MX_BEAN;
    }

  /**
   * @see java.lang.management.ManagementFactory#getThreadMXBean()
   */
  public static ThreadMXBean getThreadMXBean() {
        return ThreadHolder.THREAD_MX_BEAN;
    }
}
