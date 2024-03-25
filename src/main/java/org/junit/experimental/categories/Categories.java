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
            return new CategoryFilter(matchAny, categories, false, null);
        }

        public static CategoryFilter include(Class<?> category) {
            return new CategoryFilter(true, Collections.<Class<?>>singleton(category), true, Collections.<Class<?>><Class<?>>emptySet());
        }

        public static CategoryFilter include(Class<?>... categories) {
            return new CategoryFilter(true, categories, false, null);
        }

        public static CategoryFilter exclude(boolean matchAny, Class<?>... categories) {
            return new CategoryFilter(false, null, matchAny, categories);
        }

        public static CategoryFilter exclude(Class<?> category) {
            return new CategoryFilter(null, category);
        }

        public static CategoryFilter exclude(Class<?>... categories) {
            return new CategoryFilter(true, null, true, categories);
        }

        public static CategoryFilter categoryFilter(boolean matchAnyInclusions, Set<Class<?>> inclusions,
                                                    boolean matchAnyExclusions, Set<Class<?>> exclusions) {
            return new CategoryFilter(matchAnyInclusions, inclusions, matchAnyExclusions, exclusions);
        }

        @Deprecated
        public CategoryFilter(Class<?> includedCategory, Class<?> excludedCategory) {
            this(includedCategory, true, excludedCategory, true);
        }

        protected CategoryFilter(boolean matchAnyIncludes, Set<Class<?>> includes,
                                 boolean matchAnyExcludes, Set<Class<?>> excludes) {
            this(matchAnyIncludes, includes.toArray(new Class<?>[includes.size()]),
            matchAnyExcludes, excludes.toArray(new Class<?>[excludes.size()]));
        }

        private CategoryFilter(boolean matchAnyIncludes, Class<?>[] inclusions,
                               boolean matchAnyExcludes, Class<?>[] exclusions) {
            this(matchAnyIncludes, createSet(inclusions), matchAnyExcludes, createSet(exclusions));
        }

        /**
         * @see #toString()
         */
        @Override
        public String describe() {
            return toString();
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
            return String.format("categories %s%s - %s%s",
            includedAny ? "[any]" : "",
            included, // already in the form for copy and paste
            excludedAny ? "[any]" : "",
            excluded);
        }

        @Override
        public boolean shouldRun(Description description) {
            if (hasCorrectCategoryAnnotation(description)) {
                if (!excluded.isEmpty() && matchesAnyParentCategories(categories(description), excluded)) {
                    return false;
                }
                if (!included.isEmpty() && !matchesAnyParentCategories(categories(description), included)) {
                    return false;
                }
                return true;
            } else {
                // if neither included nor excluded categories are matched,
                // run the test to support legacy tests.
                return included.isEmpty();
            }
        }

        private boolean hasCorrectCategoryAnnotation(Description description) {
            if (included.isEmpty() && excluded.isEmpty()) {
                return false;
            }
            Set<Class<?>> childCategories = categories(description);
            return matchesAnyParentCategories(childCategories, included) &&
            !matchesAllParentCategories(childCategories, excluded);
        }

        /**
         * @return <tt>true</tt> if at least one (any) parent category match a child, otherwise <tt>false</tt>.
         * If empty <tt>parentCategories</tt>, returns <tt>false</tt>.
         */
        private boolean matchesAnyParentCategories(Set<Class<?>> childCategories, Set<Class<?>> parentCategories) {
            for (Class<?> parentCategory : parentCategories) {
                if (hasAssignableTo(childCategories, parentCategory)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * @return <tt>false</tt> if at least one parent category does not match children, otherwise <tt>true</tt>.
         * If empty <tt>parentCategories</tt>, returns <tt>true</tt>.
         */
        private boolean matchesAllParentCategories(Set<Class<?>> childCategories, Set<Class<?>> parentCategories) {
            return childCategories.containsAll(parentCategories);
        }

        private static Set<Class<?>> categories(Description description) {
            if (description.toString().equals("class")) {
                return Collections.emptySet();
            }
            Set<Class<?>> categories = new HashSet<Class<?>>();
            categories.addAll(Arrays.asList(directCategories(description)));
            categories.addAll(categories(parentDescription(description)));
            return categories;
        }

        private static Description parentDescription(Description description) {
            return Description.createSuiteDescription(description.getTestClass());
        }

        private static Class<?>[] directCategories(Description description) {
            if (description.isSuite()) {
                return new Class<?>[0];
            }
            Class<?> from = categoryAnnotationFrom(description);
            return from == null ? new Class<?>[0] : new Class<?>[] {from};
        }

        private static Set<Class<?>> copyAndRefine(Set<Class<?>> classes) {
            Set<Class<?>> c = new HashSet<Class<?>>(classes);
            c.remove(null);
            return c;
        }
    }

    public Categories(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(klass, builder);
        try {
            filter(CategoryFilter.class);
        } catch (NoTestsRemainException e) {
            throw new InitializationError(e);
        }
    }

    private static Set<Class<?>> getIncludedCategory(Class<?> klass) {
        IncludeCategory annotation= klass.getAnnotation(IncludeCategory.class);
        return createSet(annotation == null ? null : annotation.value());
    }

    private static boolean isAnyIncluded(Class<?> klass) {
        IncludeCategory annotation= klass.getAnnotation(IncludeCategory.class);
        return annotation == null || annotation.matchAny();
    }

    private static Set<Class<?>> getExcludedCategory(Class<?> klass) {
        ExcludeCategory annotation= klass.getAnnotation(ExcludeCategory.class);
        return createSet(annotation == null ? null : annotation.value());
    }

    private static boolean isAnyExcluded(Class<?> klass) {
        ExcludeCategory annotation= klass.getAnnotation(ExcludeCategory.class);
        return annotation == null || annotation.matchAny();
    }

    private static boolean hasAssignableTo(Set<Class<?>> assigns, Class<?> to) {
        for (final Class<?> from : assigns) {
            if (to.isAssignableFrom(from)) {
                return true;
            }
        }
        return false;
    }

    private static Set<Class<?>> createSet(Class<?>[] classes) {
        if (classes.length == 0) {
            return Collections.emptySet();
        }
        for (Class<?> clazz : classes) {
            if (clazz == null) {
                throw new NullPointerException("has null category");
            }
        }
        
        return classes.length == 1
        ? Collections.<Class<?>>singleton(classes[0])
        : new LinkedHashSet<Class<?>>(Arrays.asList(classes));
    }

    private static Set<Class<?>> nullableClassToSet(Class<?> nullableClass) {
        return nullableClass == null
        ? Collections.<Class<?>>emptySet()
        : Collections.<Class<?>>singleton(nullableClass);
    }
}
