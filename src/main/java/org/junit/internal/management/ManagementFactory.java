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
      
    }
  }

  private static final class RuntimeHolder {
    private static final RuntimeMXBean RUNTIME_MX_BEAN =
        getBean(FactoryHolder.getBeanObject("getRuntimeMXBean"));

    private static final RuntimeMXBean getBean(Object runtimeMxBean) {
      
    }
  }

  private static final class ThreadHolder {
    private static final ThreadMXBean THREAD_MX_BEAN =
        getBean(FactoryHolder.getBeanObject("getThreadMXBean"));

    private static final ThreadMXBean getBean(Object threadMxBean) {
      
    }
  }

  /**
   * @see java.lang.management.ManagementFactory#getRuntimeMXBean()
   */
  public static RuntimeMXBean getRuntimeMXBean() {
    
  }

  /**
   * @see java.lang.management.ManagementFactory#getThreadMXBean()
   */
  public static ThreadMXBean getThreadMXBean() {
    
  }
}
