package org.junit.runner.manipulation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.runner.Description;

/**
 * Orders tests.
 *
 * @since 4.13
 */
public final class Orderer  {
    private final Ordering ordering;

    Orderer(Ordering delegate) {
        
    }

    /**
     * Orders the descriptions.
     *
     * @return descriptions in order
     */
    public List<Description> order(Collection<Description> descriptions)
            throws InvalidOrderingException {
        
    }

    /**
     * Order the tests in <code>target</code>.
     *
     * @throws InvalidOrderingException if ordering does something invalid (like remove or add
     * children)
     */
    public void apply(Object target) throws InvalidOrderingException {
        
    }
}
