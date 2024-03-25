package org.junit.experimental.theories;

import static java.lang.String.format;

public abstract class PotentialAssignment {
    public static class CouldNotGenerateValueException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public CouldNotGenerateValueException() {
            super();
        }
        
        public CouldNotGenerateValueException(Throwable e) {
            super(e);
        }
    }

    public static PotentialAssignment forValue(final String name, final Object value) {
        return new PotentialAssignment() {
            @Override
            public Object getValue() {
                return value;
            }
            
            @Override
            public String toString() {
                return format("[%s]", value);
            }
            
            @Override
            public String getDescription() {
                String valueString;
                try {
                    valueString = String.valueOf(value);
                } catch (Throwable e) {
                    valueString = String.format(
                    "an exception <[%s] thrown by %s.toString()>",
                    e.toString(), value.getClass().getName());
                }
                return format("%s <of type %s>", name, valueString);
            }
        };
    }

    public abstract Object getValue() throws CouldNotGenerateValueException;

    public abstract String getDescription() throws CouldNotGenerateValueException;
}