package org.junit.runners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;

import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * Data structure for ordering of {@link TestRule}/{@link MethodRule} instances.
 *
 * @since 4.13
 */
class RuleContainer {
    private final IdentityHashMap<Object, Integer> orderValues = new IdentityHashMap<Object, Integer>();
    private final List<TestRule> testRules = new ArrayList<TestRule>();
    private final List<MethodRule> methodRules = new ArrayList<MethodRule>();

    /**
     * Sets order value for the specified rule.
     */
    public void setOrder(Object rule, int order) {
        
    }

    public void add(MethodRule methodRule) {
        
    }

    public void add(TestRule testRule) {
        
    }

    static final Comparator<RuleEntry> ENTRY_COMPARATOR = new Comparator<RuleEntry>() {
        public int compare(RuleEntry o1, RuleEntry o2) {
            
        }

        private int compareInt(int a, int b) {
            
        }
    };

    /**
     * Returns entries in the order how they should be applied, i.e. inner-to-outer.
     */
    private List<RuleEntry> getSortedEntries() {
        
    }

    /**
     * Applies all the rules ordered accordingly to the specified {@code statement}.
     */
    public Statement apply(FrameworkMethod method, Description description, Object target,
            Statement statement) {
        
    }

    /**
     * Returns rule instances in the order how they should be applied, i.e. inner-to-outer.
     * VisibleForTesting
     */
    List<Object> getSortedRules() {
        
    }

    static class RuleEntry {
        static final int TYPE_TEST_RULE = 1;
        static final int TYPE_METHOD_RULE = 0;

        final Object rule;
        final int type;
        final int order;

        RuleEntry(Object rule, int type, Integer order) {
            
        }
    }
}
