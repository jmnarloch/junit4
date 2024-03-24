package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.internal.Classes;
import org.junit.runner.FilterFactory.FilterNotCreatedException;
import org.junit.runner.manipulation.Filter;
import org.junit.runners.model.InitializationError;

class JUnitCommandLineParseResult {
    private final List<String> filterSpecs = new ArrayList<String>();
    private final List<Class<?>> classes = new ArrayList<Class<?>>();
    private final List<Throwable> parserErrors = new ArrayList<Throwable>();

    /**
     * Do not use. Testing purposes only.
     */
    JUnitCommandLineParseResult() { }

    /**
     * Returns filter specs parsed from command line.
     */
    public List<String> getFilterSpecs() {
        
    }

    /**
     * Returns test classes parsed from command line.
     */
    public List<Class<?>> getClasses() {
        
    }

    /**
     * Parses the arguments.
     *
     * @param args Arguments
     */
    public static JUnitCommandLineParseResult parse(String[] args) {
        
    }

    private void parseArgs(String[] args) {
        
    }

    String[] parseOptions(String... args) {
        
    }

    private String[] copyArray(String[] args, int from, int to) {
        
    }

    void parseParameters(String[] args) {
        
    }

    private Request errorReport(Throwable cause) {
        
    }

    /**
     * Creates a {@link Request}.
     *
     * @param computer {@link Computer} to be used.
     */
    public Request createRequest(Computer computer) {
        
    }

    private Request applyFilterSpecs(Request request) {
        
    }

    /**
     * Exception used if there's a problem parsing the command line.
     */
    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID= 1L;

        public CommandLineParserError(String message) {
            
        }
    }
}
