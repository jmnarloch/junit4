package org.junit.internal.management;

import org.junit.internal.Classes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Implementation of {@link ThreadMXBean} using the JVM reflectively.
 */
final class ReflectiveThreadMXBean implements ThreadMXBean {
  private final Object threadMxBean;


  private static final class Holder {
    static final Method getThreadCpuTimeMethod;
    static final Method isThreadCpuTimeSupportedMethod;

    private static final String FAILURE_MESSAGE = "Unable to access ThreadMXBean";

    static {
      Method threadCpuTime = null;
      Method threadCpuTimeSupported = null;
      try {
        Class<?> threadMXBeanClass = Classes.getClass("java.lang.management.ThreadMXBean");
        threadCpuTime = threadMXBeanClass.getMethod("getThreadCpuTime", long.class);
        threadCpuTimeSupported = threadMXBeanClass.getMethod("isThreadCpuTimeSupported");
      } catch (ClassNotFoundException e) {
        // do nothing, the methods will be null on failure
      } catch (NoSuchMethodException e) {
        // do nothing, the methods will be null on failure
      } catch (SecurityException e) {
        // do nothing, the methods will be null on failure
      }
      getThreadCpuTimeMethod = threadCpuTime;
      isThreadCpuTimeSupportedMethod = threadCpuTimeSupported;
    }
  }

  ReflectiveThreadMXBean(Object threadMxBean) {
    
  }

  /**
   * {@inheritDoc}
   */
  public long getThreadCpuTime(long id) {
    
  }

  /**
   * {@inheritDoc}
   */
  public boolean isThreadCpuTimeSupported() {
    
  }

}

