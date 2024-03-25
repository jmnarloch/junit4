package org.junit.runners;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InvalidTestClassError;
import org.junit.runners.model.TestClass;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

/**
 * The custom runner <code>Parameterized</code> implements parameterized tests.
 * When running a parameterized test class, instances are created for the
 * cross-product of the test methods and the test data elements.
 * <p>
 * For example, to test the <code>+</code> operator, write:
 * <pre>
 * &#064;RunWith(Parameterized.class)
 * public class AdditionTest {
 *     &#064;Parameters(name = &quot;{index}: {0} + {1} = {2}&quot;)
 *     public static Iterable&lt;Object[]&gt; data() {
 *         return Arrays.asList(new Object[][] { { 0, 0, 0 }, { 1, 1, 2 },
 *                 { 3, 2, 5 }, { 4, 3, 7 } });
 *     }
 *
 *     private int firstSummand;
 *
 *     private int secondSummand;
 *
 *     private int sum;
 *
 *     public AdditionTest(int firstSummand, int secondSummand, int sum) {
 *         this.firstSummand = firstSummand;
 *         this.secondSummand = secondSummand;
 *         this.sum = sum;
 *     }
 *
 *     &#064;Test
 *     public void test() {
 *         assertEquals(sum, firstSummand + secondSummand);
 *     }
 * }
 * </pre>
 * <p>
 * Each instance of <code>AdditionTest</code> will be constructed using the
 * three-argument constructor and the data values in the
 * <code>&#064;Parameters</code> method.
 * <p>
 * In order that you can easily identify the individual tests, you may provide a
 * name for the <code>&#064;Parameters</code> annotation. This name is allowed
 * to contain placeholders, which are replaced at runtime. The placeholders are
 * <dl>
 * <dt>{index}</dt>
 * <dd>the current parameter index</dd>
 * <dt>{0}</dt>
 * <dd>the first parameter value</dd>
 * <dt>{1}</dt>
 * <dd>the second parameter value</dd>
 * <dt>...</dt>
 * <dd>...</dd>
 * </dl>
 * <p>
 * In the example given above, the <code>Parameterized</code> runner creates
 * names like <code>[2: 3 + 2 = 5]</code>. If you don't use the name parameter,
 * then the current parameter index is used as name.
 * <p>
 * You can also write:
 * <pre>
 * &#064;RunWith(Parameterized.class)
 * public class AdditionTest {
 *     &#064;Parameters(name = &quot;{index}: {0} + {1} = {2}&quot;)
 *     public static Iterable&lt;Object[]&gt; data() {
 *         return Arrays.asList(new Object[][] { { 0, 0, 0 }, { 1, 1, 2 },
 *                 { 3, 2, 5 }, { 4, 3, 7 } });
 *     }
 *
 *     &#064;Parameter(0)
 *     public int firstSummand;
 *
 *     &#064;Parameter(1)
 *     public int secondSummand;
 *
 *     &#064;Parameter(2)
 *     public int sum;
 *
 *     &#064;Test
 *     public void test() {
 *         assertEquals(sum, firstSummand + secondSummand);
 *     }
 * }
 * </pre>
 * <p>
 * Each instance of <code>AdditionTest</code> will be constructed with the default constructor
 * and fields annotated by <code>&#064;Parameter</code>  will be initialized
 * with the data values in the <code>&#064;Parameters</code> method.
 *
 * <p>
 * The parameters can be provided as an array, too:
 * 
 * <pre>
 * &#064;Parameters
 * public static Object[][] data() {
 * 	return new Object[][] { { 0, 0, 0 }, { 1, 1, 2 }, { 3, 2, 5 }, { 4, 3, 7 } } };
 * }
 * </pre>
 * 
 * <h3>Tests with single parameter</h3>
 * <p>
 * If your test needs a single parameter only, you don't have to wrap it with an
 * array. Instead you can provide an <code>Iterable</code> or an array of
 * objects.
 * <pre>
 * &#064;Parameters
 * public static Iterable&lt;? extends Object&gt; data() {
 * 	return Arrays.asList(&quot;first test&quot;, &quot;second test&quot;);
 * }
 * </pre>
 * <p>
 * or
 * <pre>
 * &#064;Parameters
 * public static Object[] data() {
 * 	return new Object[] { &quot;first test&quot;, &quot;second test&quot; };
 * }
 * </pre>
 *
 * <h3>Executing code before/after executing tests for specific parameters</h3>
 * <p>
 * If your test needs to perform some preparation or cleanup based on the
 * parameters, this can be done by adding public static methods annotated with
 * {@code @BeforeParam}/{@code @AfterParam}. Such methods should either have no
 * parameters or the same parameters as the test.
 * <pre>
 * &#064;BeforeParam
 * public static void beforeTestsForParameter(String onlyParameter) {
 *     System.out.println("Testing " + onlyParameter);
 * }
 * </pre>
 *
 * <h3>Create different runners</h3>
 * <p>
 * By default the {@code Parameterized} runner creates a slightly modified
 * {@link BlockJUnit4ClassRunner} for each set of parameters. You can build an
 * own {@code Parameterized} runner that creates another runner for each set of
 * parameters. Therefore you have to build a {@link ParametersRunnerFactory}
 * that creates a runner for each {@link TestWithParameters}. (
 * {@code TestWithParameters} are bundling the parameters and the test name.)
 * The factory must have a public zero-arg constructor.
 *
 * <pre>
 * public class YourRunnerFactory implements ParametersRunnerFactory {
 *     public Runner createRunnerForTestWithParameters(TestWithParameters test)
 *             throws InitializationError {
 *         return YourRunner(test);
 *     }
 * }
 * </pre>
 * <p>
 * Use the {@link UseParametersRunnerFactory} to tell the {@code Parameterized}
 * runner that it should use your factory.
 *
 * <pre>
 * &#064;RunWith(Parameterized.class)
 * &#064;UseParametersRunnerFactory(YourRunnerFactory.class)
 * public class YourTest {
 *     ...
 * }
 * </pre>
 *
 * <h3>Avoid creating parameters</h3>
 * <p>With {@link org.junit.Assume assumptions} you can dynamically skip tests.
 * Assumptions are also supported by the <code>&#064;Parameters</code> method.
 * Creating parameters is stopped when the assumption fails and none of the
 * tests in the test class is executed. JUnit reports a
 * {@link Result#getAssumptionFailureCount() single assumption failure} for the
 * whole test class in this case.
 * <pre>
 * &#064;Parameters
 * public static Iterable&lt;? extends Object&gt; data() {
 * 	String os = System.getProperty("os.name").toLowerCase()
 * 	Assume.assumeTrue(os.contains("win"));
 * 	return Arrays.asList(&quot;first test&quot;, &quot;second test&quot;);
 * }
 * </pre>
 * @since 4.0
 */
public class Parameterized extends Suite {
    /**
     * Annotation for a method which provides parameters to be injected into the
     * test class constructor by <code>Parameterized</code>. The method has to
     * be public and static.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Parameters {
        /**
         * Optional pattern to derive the test's name from the parameters. Use
         * numbers in braces to refer to the parameters or the additional data
         * as follows:
         * <pre>
         * {index} - the current parameter index
         * {0} - the first parameter value
         * {1} - the second parameter value
         * etc...
         * </pre>
         * <p>
         * Default value is "{index}" for compatibility with previous JUnit
         * versions.
         *
         * @return {@link MessageFormat} pattern string, except the index
         *         placeholder.
         * @see MessageFormat
         */
        String name() default "{index}";
    }

    /**
     * Annotation for fields of the test class which will be initialized by the
     * method annotated by <code>Parameters</code>.
     * By using directly this annotation, the test class constructor isn't needed.
     * Index range must start at 0.
     * Default value is 0.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Parameter {
        /**
         * Method that returns the index of the parameter in the array
         * returned by the method annotated by <code>Parameters</code>.
         * Index range must start at 0.
         * Default value is 0.
         *
         * @return the index of the parameter.
         */
        int value() default 0;
    }

    /**
     * Add this annotation to your test class if you want to generate a special
     * runner. You have to specify a {@link ParametersRunnerFactory} class that
     * creates such runners. The factory must have a public zero-arg
     * constructor.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Target(ElementType.TYPE)
    public @interface UseParametersRunnerFactory {
        /**
         * @return a {@link ParametersRunnerFactory} class (must have a default
         *         constructor)
         */
        Class<? extends ParametersRunnerFactory> value() default BlockJUnit4ClassRunnerWithParametersFactory.class;
    }

    /**
     * Annotation for {@code public static void} methods which should be executed before
     * evaluating tests with particular parameters.
     *
     * @see org.junit.BeforeClass
     * @see org.junit.Before
     * @since 4.13
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface BeforeParam {
    }

    /**
     * Annotation for {@code public static void} methods which should be executed after
     * evaluating tests with particular parameters.
     *
     * @see org.junit.AfterClass
     * @see org.junit.After
     * @since 4.13
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface AfterParam {
    }

    /**
     * Only called reflectively. Do not use programmatically.
     */
    public Parameterized(Class<?> klass) throws Throwable {
        this(klass, new RunnersFactory(klass));
    }

    private Parameterized(Class<?> klass, RunnersFactory runnersFactory) throws Exception {
        super(klass, runnersFactory.createRunners());
    }

    private void validateBeforeParamAndAfterParamMethods(Integer parameterCount)
            throws InvalidTestClassError {
        List<Throwable> errors = new ArrayList<Throwable>();
        validatePublicStaticVoidMethods(Parameterized.BeforeParam.class, parameterCount, errors);
        validatePublicStaticVoidMethods(Parameterized.AfterParam.class, parameterCount, errors);
        if (!errors.isEmpty()) {
            throw new InvalidTestClassError(getTestClass().getJavaClass(), errors);
        }
    }

    private void validatePublicStaticVoidMethods(
            Class<? extends Annotation> annotation, Integer parameterCount,
            List<Throwable> errors) {
        List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(annotation);
        for (FrameworkMethod eachTestMethod : methods) {
            eachTestMethod.validatePublicVoid(true, errors);
            validateOneParameterCount(eachTestMethod, errors, annotation, parameterCount);
        }
    }

    private static class AssumptionViolationRunner extends Runner {
        private final Description description;
        private final AssumptionViolatedException exception;

        AssumptionViolationRunner(TestClass testClass, String methodName,
                AssumptionViolatedException exception) {
            this.exception = exception;
            description = testClass.method(methodName).getDescription();
        }

        @Override
        public Description getDescription() {
            return description;
        }

        @Override
        public void run(RunNotifier notifier) {
            notifier.fireTestAssumptionFailed(description, exception);
        }
    }

    private static class RunnersFactory {
        private static final ParametersRunnerFactory DEFAULT_FACTORY = new BlockJUnit4ClassRunnerWithParametersFactory();

        private final TestClass testClass;
        private final FrameworkMethod parametersMethod;
        private final List<Object> allParameters;
        private final int parameterCount;
        private final Runner runnerOverride;

        private RunnersFactory(Class<?> klass) throws Throwable {
            this.testClass = new TestClass(klass);
            this.parametersMethod = getParametersMethod(testClass);
            this.allParameters = allParameters(testClass, parametersMethod);
            this.parameterCount = allParameters.size();
            this.runnerOverride = computeRunnerTest(klass);
        }

        private List<Runner> createRunners() throws Exception {
            try {
                return createRunnersForParameters(allParameters, parametersMethod.getAnnotation(
                Parameterized.Parameters.class).name(), getParametersRunnerFactory());
            } catch (ClassCastException e) {
                throw parametersMethodReturnedWrongType(testClass, parametersMethod);
            }
        }

        private ParametersRunnerFactory getParametersRunnerFactory()
                throws InstantiationException, IllegalAccessException {
            UseParametersRunnerFactory annotation = testClass
            .getJavaClass().getAnnotation(UseParametersRunnerFactory.class);
            if (annotation != null) {
                return annotation.value().newInstance();
            } else {
                return DEFAULT_FACTORY;
            }
        }

        private TestWithParameters createTestWithNotNormalizedParameters(
                String pattern, int index, Object parametersOrSingleParameter) {
            Object[] parameters = normalizeParameters(parametersOrSingleParameter);
            return createTestWithParameters(testClass, pattern, index, parameters);
        }

        private static Object[] normalizeParameters(Object parametersOrSingleParameter) {
            if (parametersOrSingleParameter instanceof Collection<?>) {
                return ((Collection<?>) parametersOrSingleParameter).toArray();
            } else {
                return (Object[]) parametersOrSingleParameter;
            }
        }

        @SuppressWarnings("unchecked")
        private static List<Object> allParameters(
                TestClass testClass, FrameworkMethod parametersMethod) throws Throwable {
            return (List<Object>) parametersMethod.invokeExplosively(null, testClass);
        }

        private static FrameworkMethod getParametersMethod(TestClass testClass) throws Exception {
            List<FrameworkMethod> methods = testClass.getAnnotatedMethods(Parameters.class);
            for (FrameworkMethod each : methods) {
                each.validatePublicStatic(0, false);
            }
            
            if (methods.size() > 1) {
                throw new Exception("Test class can only have one method annotated with @Parameters.");
            }
            
            if (methods.isEmpty()) {
                throw new Exception("Test class must have at least one public static method annotated with @Parameters.");
            }
            
            return methods.get(0);
        }

        private List<Runner> createRunnersForParameters(
                Iterable<Object> allParameters, String namePattern,
                ParametersRunnerFactory runnerFactory) throws Exception {
            try {
                List<Runner> runners = new ArrayList<Runner>();
                for (TestWithParameters test : createTestsForParameters(
                allParameters, namePattern)) {
                    runners.add(runnerFactory.createRunnerWithNotNormalizedParameters(test));
                }
                return runners;
            } catch (ClassCastException e) {
                throw parametersMethodReturnedWrongType(testClass, parametersMethod);
            }
        }

        private List<TestWithParameters> createTestsForParameters(
                Iterable<Object> allParameters, String namePattern)
                throws Exception {
            List<TestWithParameters> tests = new ArrayList<TestWithParameters>();
            int i = 0;
            for (Object parametersOfSingleTest : allParameters) {
                i++;
                if (parametersOfSingleTest instanceof Object[]) {
                    Object[] parameters = (Object[]) parametersOfSingleTest;
                    if (parametersOfSingleTest instanceof Object[]) {
                        parameters = (Object[]) parametersOfSingleTest;
                    } else {
                        parameters = new Object[] { parametersOfSingleTest };
                    }
                    tests.add(createTestWithParameters(testClass, namePattern, i, parameters));
                } else {
                    tests.add(createTestWithParameters(testClass, namePattern, i,
                    new Object[] { parametersOfSingleTest }));
                }
            }
            return tests;
        }

        private static Exception parametersMethodReturnedWrongType(
                TestClass testClass, FrameworkMethod parametersMethod) throws Exception {
            String className = testClass.getName();
            String methodName = parametersMethod.getName();
            return new Exception(
            MessageFormat.format(
            "{0}.{1}() must return an Iterable of arrays.",
            className, methodName));
        }

        private TestWithParameters createTestWithParameters(
                TestClass testClass, String pattern, int index,
                Object[] parameters) {
            String finalPattern = pattern.replaceAll("\\{index\\}", String.valueOf(index));
            return new TestWithParameters(String.format("%s(%s)", finalPattern, Arrays.toString(parameters)),
            testClass, parameters);
        }
    }
}
