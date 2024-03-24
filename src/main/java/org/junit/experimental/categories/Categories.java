package org.junit.experimental.categories;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * From a given set of test classes, runs only the classes and methods that are
 * annotated with either the category given with the @IncludeCategory
 * annotation, or a subtype of that category.
 * <p>
 * Note that, for now, annotating suites with {@code @Category} has no effect.
 * Categories must be annotated on the direct method or class.
 * <p>
 * Example:
 * <pre>
 * public interface FastTests {
 * }
 *
 * public interface SlowTests {
 * }
 *
 * public interface SmokeTests
 * }
 *
 * public static class A {
 *     &#064;Test
 *     public void a() {
 *         fail();
 *     }
 *
 *     &#064;Category(SlowTests.class)
 *     &#064;Test
 *     public void b() {
 *     }
 *
 *     &#064;Category({FastTests.class, SmokeTests.class})
 *     &#064;Test
 *     public void c() {
 *     }
 * }
 *
 * &#064;Category({SlowTests.class, FastTests.class})
 * public static class B {
 *     &#064;Test
 *     public void d() {
 *     }
 * }
 *
 * &#064;RunWith(Categories.class)
 * &#064;IncludeCategory(SlowTests.class)
 * &#064;SuiteClasses({A.class, B.class})
 * // Note that Categories is a kind of Suite
 * public static class SlowTestSuite {
 *     // Will run A.b and B.d, but not A.a and A.c
 * }
 * </pre>
 * <p>
 * Example to run multiple categories:
 * <pre>
 * &#064;RunWith(Categories.class)
 * &#064;IncludeCategory({FastTests.class, SmokeTests.class})
 * &#064;SuiteClasses({A.class, B.class})
 * public static class FastOrSmokeTestSuite {
 *     // Will run A.c and B.d, but not A.b because it is not any of FastTests or SmokeTests
 * }
 * </pre>
 *
 * @version 4.12
 * @see <a href="https://github.com/junit-team/junit4/wiki/Categories">Categories at JUnit wiki</a>
 */
public class Categories extends Suite {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface IncludeCategory {
        /**
         * Determines the tests to run that are annotated with categories specified in
         * the value of this annotation or their subtypes unless excluded with {@link ExcludeCategory}.
         */
        Class<?>[] value() default {};

        /**
         * If <tt>true</tt>, runs tests annotated with <em>any</em> of the categories in
         * {@link IncludeCategory#value()}. Otherwise, runs tests only if annotated with <em>all</em> of the categories.
         */
        boolean matchAny() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExcludeCategory {
        /**
         * Determines the tests which do not run if they are annotated with categories specified in the
         * value of this annotation or their subtypes regardless of being included in {@link IncludeCategory#value()}.
         */
        Class<?>[] value() default {};

        /**
         * If <tt>true</tt>, the tests annotated with <em>any</em> of the categories in {@link ExcludeCategory#value()}
         * do not run. Otherwise, the tests do not run if and only if annotated with <em>all</em> categories.
         */
        boolean matchAny() default true;
    }

    public static class CategoryFilter extends Filter {
        private final Set<Class<?>> included;
        private final Set<Class<?>> excluded;
        private final boolean includedAny;
        private final boolean excludedAny;

        public static CategoryFilter include(boolean matchAny, Class<?>... categories) {
            
        }

        public static CategoryFilter include(Class<?> category) {
            
        }

        public static CategoryFilter include(Class<?>... categories) {
            
        }

        public static CategoryFilter exclude(boolean matchAny, Class<?>... categories) {
            
        }

        public static CategoryFilter exclude(Class<?> category) {
            
        }

        public static CategoryFilter exclude(Class<?>... categories) {
            
        }

        public static CategoryFilter categoryFilter(boolean matchAnyInclusions, Set<Class<?>> inclusions,
                                                    boolean matchAnyExclusions, Set<Class<?>> exclusions) {
            
        }

        @Deprecated
        public CategoryFilter(Class<?> includedCategory, Class<?> excludedCategory) {
            
        }

        protected CategoryFilter(boolean matchAnyIncludes, Set<Class<?>> includes,
                                 boolean matchAnyExcludes, Set<Class<?>> excludes) {
            
        }

        private CategoryFilter(boolean matchAnyIncludes, Class<?>[] inclusions,
                               boolean matchAnyExcludes, Class<?>[] exclusions) {
            
        }

        /**
         * @see #toString()
         */
        @Override
        public String describe() {
            
        }

        /**
         * Returns string in the form <tt>&quot;[included categories] - [excluded categories]&quot;</tt>, where both
         * sets have comma separated names of categories.
         *
         * @return string representation for the relative complement of excluded categories set
         * in the set of included categories. Examples:
         * <ul>
         *  <li> <tt>&quot;categories [all]&quot;</tt> for all included categories and no excluded ones;
         *  <li> <tt>&quot;categories [all] - [A, B]&quot;</tt> for all included categories and given excluded ones;
         *  <li> <tt>&quot;categories [A, B] - [C, D]&quot;</tt> for given included categories and given excluded ones.
         * </ul>
         * @see Class#toString() name of category
         */
        @Override public String toString() {
            
        }

        @Override
        public boolean shouldRun(Description description) {
            
        }

        private boolean hasCorrectCategoryAnnotation(Description description) {
            
        }

        /**
         * @return <tt>true</tt> if at least one (any) parent category match a child, otherwise <tt>false</tt>.
         * If empty <tt>parentCategories</tt>, returns <tt>false</tt>.
         */
        private boolean matchesAnyParentCategories(Set<Class<?>> childCategories, Set<Class<?>> parentCategories) {
            
        }

        /**
         * @return <tt>false</tt> if at least one parent category does not match children, otherwise <tt>true</tt>.
         * If empty <tt>parentCategories</tt>, returns <tt>true</tt>.
         */
        private boolean matchesAllParentCategories(Set<Class<?>> childCategories, Set<Class<?>> parentCategories) {
            
        }

        private static Set<Class<?>> categories(Description description) {
            
        }

        private static Description parentDescription(Description description) {
            
        }

        private static Class<?>[] directCategories(Description description) {
            
        }

        private static Set<Class<?>> copyAndRefine(Set<Class<?>> classes) {
            
        }
    }

    public Categories(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        
    }

    private static Set<Class<?>> getIncludedCategory(Class<?> klass) {
        
    }

    private static boolean isAnyIncluded(Class<?> klass) {
        
    }

    private static Set<Class<?>> getExcludedCategory(Class<?> klass) {
        
    }

    private static boolean isAnyExcluded(Class<?> klass) {
        
    }

    private static boolean hasAssignableTo(Set<Class<?>> assigns, Class<?> to) {
        
    }

    private static Set<Class<?>> createSet(Class<?>[] classes) {
        // Not throwing a NPE if t is null is a bad idea, but it's the behavior from JUnit 4.12
        // for include(boolean, Class<?>...) and exclude(boolean, Class<?>...)
        
    }

    private static Set<Class<?>> nullableClassToSet(Class<?> nullableClass) {
        // Not throwing a NPE if t is null is a bad idea, but it's the behavior from JUnit 4.11
        // for CategoryFilter(Class<?> includedCategory, Class<?> excludedCategory)
        
    }
}
