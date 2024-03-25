package org.junit.runner;

import org.junit.internal.Classes;
import org.junit.runner.FilterFactory.FilterNotCreatedException;
import org.junit.runner.manipulation.Filter;

/**
 * Utility class whose methods create a {@link FilterFactory}.
 */
class FilterFactories {
    /**
     * Creates a {@link Filter}.
     *
     * A filter specification is of the form "package.of.FilterFactory=args-to-filter-factory" or
     * "package.of.FilterFactory".
     *
     * @param request the request that will be filtered
     * @param filterSpec the filter specification
     */
    public static Filter createFilterFromFilterSpec(Request request, String filterSpec)
            throws FilterFactory.FilterNotCreatedException {
        Description description = request.getRunner().getDescription();
        return createFilter(filterSpec, new FilterFactoryParams(description, request.getRunner().getRunnerService()));
    }

    /**
     * Creates a {@link Filter}.
     *
     * @param filterFactoryFqcn The fully qualified class name of the {@link FilterFactory}
     * @param params The arguments to the {@link FilterFactory}
     */
    public static Filter createFilter(String filterFactoryFqcn, FilterFactoryParams params)
            throws FilterFactory.FilterNotCreatedException {
        FilterFactory filterFactory = createFilterFactory(filterFactoryFqcn);
        
        return filterFactory.createFilter(params);
    }

    /**
     * Creates a {@link Filter}.
     *
     * @param filterFactoryClass The class of the {@link FilterFactory}
     * @param params             The arguments to the {@link FilterFactory}
     *
     */
    public static Filter createFilter(Class<? extends FilterFactory> filterFactoryClass, FilterFactoryParams params)
            throws FilterFactory.FilterNotCreatedException {
        FilterFactory filterFactory = createFilterFactory(filterFactoryClass);
        
        return filterFactory.createFilter(params);
    }

    static FilterFactory createFilterFactory(String filterFactoryFqcn) throws FilterNotCreatedException {
        Class<? extends FilterFactory> filterFactoryClass;
        
        try {
            filterFactoryClass = Classes.getClass(filterFactoryFqcn).asSubclass(FilterFactory.class);
        } catch (Exception e) {
            throw new FilterNotCreatedException(e);
        }
        
        return createFilterFactory(filterFactoryClass);
    }

    static FilterFactory createFilterFactory(Class<? extends FilterFactory> filterFactoryClass)
            throws FilterNotCreatedException {
        try {
            return filterFactoryClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new FilterNotCreatedException(e);
        }
    }
}
