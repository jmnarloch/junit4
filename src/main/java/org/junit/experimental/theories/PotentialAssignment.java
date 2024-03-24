package org.junit.experimental.theories;

import static java.lang.String.format;

public abstract class PotentialAssignment {
    public static class CouldNotGenerateValueException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public CouldNotGenerateValueException() { }
        
        public CouldNotGenerateValueException(Throwable e) {
            
        }
    }

    public static PotentialAssignment forValue(final String name, final Object value) {
        
    }

    public abstract Object getValue() throws CouldNotGenerateValueException;

    public abstract String getDescription() throws CouldNotGenerateValueException;
}