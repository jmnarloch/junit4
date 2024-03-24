package org.junit.rules;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Rule;

/**
 * The TemporaryFolder Rule allows creation of files and folders that should
 * be deleted when the test method finishes (whether it passes or
 * fails).
 * By default no exception will be thrown in case the deletion fails.
 *
 * <p>Example of usage:
 * <pre>
 * public static class HasTempFolder {
 *  &#064;Rule
 *  public TemporaryFolder folder= new TemporaryFolder();
 *
 *  &#064;Test
 *  public void testUsingTempFolder() throws IOException {
 *      File createdFile= folder.newFile(&quot;myfile.txt&quot;);
 *      File createdFolder= folder.newFolder(&quot;subfolder&quot;);
 *      // ...
 *     }
 * }
 * </pre>
 *
 * <p>TemporaryFolder rule supports assured deletion mode, which
 * will fail the test in case deletion fails with {@link AssertionError}.
 *
 * <p>Creating TemporaryFolder with assured deletion:
 * <pre>
 *  &#064;Rule
 *  public TemporaryFolder folder= TemporaryFolder.builder().assureDeletion().build();
 * </pre>
 *
 * @since 4.7
 */
public class TemporaryFolder extends ExternalResource {
    private final File parentFolder;
    private final boolean assureDeletion;
    private File folder;

    private static final int TEMP_DIR_ATTEMPTS = 10000;
    private static final String TMP_PREFIX = "junit";

    /**
     * Create a temporary folder which uses system default temporary-file 
     * directory to create temporary resources.
     */
    public TemporaryFolder() {
        
    }

    /**
     * Create a temporary folder which uses the specified directory to create
     * temporary resources.
     *
     * @param parentFolder folder where temporary resources will be created.
     * If {@code null} then system default temporary-file directory is used.
     */
    public TemporaryFolder(File parentFolder) {
        
    }

    /**
     * Create a {@link TemporaryFolder} initialized with
     * values from a builder.
     */
    protected TemporaryFolder(Builder builder) {
        
    }

    /**
     * Returns a new builder for building an instance of {@link TemporaryFolder}.
     *
     * @since 4.13
     */
    public static Builder builder() {
        
    }

    /**
     * Builds an instance of {@link TemporaryFolder}.
     * 
     * @since 4.13
     */
    public static class Builder {
        private File parentFolder;
        private boolean assureDeletion;

        protected Builder() { }

        /**
         * Specifies which folder to use for creating temporary resources.
         * If {@code null} then system default temporary-file directory is
         * used.
         *
         * @return this
         */
        public Builder parentFolder(File parentFolder) {
            
        }

        /**
         * Setting this flag assures that no resources are left undeleted. Failure
         * to fulfill the assurance results in failure of tests with an
         * {@link AssertionError}.
         *
         * @return this
         */
        public Builder assureDeletion() {
            
        }

        /**
         * Builds a {@link TemporaryFolder} instance using the values in this builder.
         */
        public TemporaryFolder build() {
            
        }
    }

    @Override
    protected void before() throws Throwable {
        
    }

    @Override
    protected void after() {
        
    }

    // testing purposes only

    /**
     * for testing purposes only. Do not use.
     */
    public void create() throws IOException {
        
    }

    /**
     * Returns a new fresh file with the given name under the temporary folder.
     */
    public File newFile(String fileName) throws IOException {
        
    }

    /**
     * Returns a new fresh file with a random name under the temporary folder.
     */
    public File newFile() throws IOException {
        
    }

    /**
     * Returns a new fresh folder with the given path under the temporary
     * folder.
     */
    public File newFolder(String path) throws IOException {
        
    }

    /**
     * Returns a new fresh folder with the given paths under the temporary
     * folder. For example, if you pass in the strings {@code "parent"} and {@code "child"}
     * then a directory named {@code "parent"} will be created under the temporary folder
     * and a directory named {@code "child"} will be created under the newly-created
     * {@code "parent"} directory.
     */
    public File newFolder(String... paths) throws IOException {
        
    }

    /**
     * Returns a new fresh folder with a random name under the temporary folder.
     */
    public File newFolder() throws IOException {
        
    }

    private static File createTemporaryFolderIn(File parentFolder) throws IOException {
        
    }

    private static File createTemporaryFolderWithNioApi(File parentFolder) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        
    }

    private static File createTemporaryFolderWithFileApi(File parentFolder) throws IOException {
        
    }

    /**
     * @return the location of this temporary folder.
     */
    public File getRoot() {
        
    }

    /**
     * Delete all files and folders under the temporary folder. Usually not
     * called directly, since it is automatically applied by the {@link Rule}.
     *
     * @throws AssertionError if unable to clean up resources
     * and deletion of resources is assured.
     */
    public void delete() {
        
    }

    /**
     * Tries to delete all files and folders under the temporary folder and
     * returns whether deletion was successful or not.
     *
     * @return {@code true} if all resources are deleted successfully,
     *         {@code false} otherwise.
     */
    private boolean tryDelete() {
        
    }

    private boolean recursiveDelete(File file) {
        // Try deleting file before assuming file is a directory
        // to prevent following symbolic links.
        
    }
}
