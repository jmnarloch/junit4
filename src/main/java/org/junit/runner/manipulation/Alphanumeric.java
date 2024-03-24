package org.junit.runner.manipulation;

import java.util.Comparator;

import org.junit.runner.Description;

/**
 * A sorter that orders tests alphanumerically by test name.
 *
 * @since 4.13
 */
public final class Alphanumeric extends Sorter implements Ordering.Factory {

    public Alphanumeric() {
        
    }

    public Ordering create(Context context) {
        
    }

    private static final Comparator<Description> COMPARATOR = new Comparator<Description>() {
        public int compare(Description o1, Description o2) {
            
        }
    };
}
