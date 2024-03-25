package org.junit.runner.manipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runner.Description;

/**
 * A <code>Sorter</code> orders tests. In general you will not need
 * to use a <code>Sorter</code> directly. Instead, use
 * {@link org.junit.runner.Request#sortWith(Comparator)}.
 *
 * @since 4.0
 */
public class Sorter extends Ordering implements Comparator<Description> {
    /**
     * NULL is a <code>Sorter</code> that leaves elements in an undefined order
     */
    public static final Sorter NULL = new Sorter(new Comparator<Description>() {
        public int compare(Description o1, Description o2) {
        return o1.getDisplayName().compareTo(o2.getDisplayName());
    }
    });

    private final Comparator<Description> comparator;

    /**
     * Creates a <code>Sorter</code> that uses <code>comparator</code>
     * to sort tests
     *
     * @param comparator the {@link Comparator} to use when sorting tests
     * @since 4.0
     */
    public Sorter(Comparator<Description> comparator) {
        this.comparator = comparator;
    }

    /**
     * Sorts the tests in <code>target</code> using <code>comparator</code>.
     *
     * @since 4.0
     */
    @Override
    public void apply(Object target) {
        if (target instanceof Sortable) {
            Sortable sortable = (Sortable) target;
            sortable.sort(this);
        }
    }

    public int compare(Description o1, Description o2) {
        return o1.getDisplayName().compareTo(o2.getDisplayName());
    }
 
    /**
     * {@inheritDoc}
     *
     * @since 4.13
     */
    @Override
    protected final List<Description> orderItems(Collection<Description> descriptions) {
        List<Description> result = new ArrayList<Description>(descriptions);
        Collections.sort(result, this);
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * @since 4.13
     */
    @Override
    boolean validateOrderingIsCorrect() {
        return false;
    }
}
