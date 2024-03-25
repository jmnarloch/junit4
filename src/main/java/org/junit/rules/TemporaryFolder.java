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
        this((File) null);
    }

    /**
     * Create a temporary folder which uses the specified directory to create
     * temporary resources.
     *
     * @param parentFolder folder where temporary resources will be created.
     * If {@code null} then system default temporary-file directory is used.
     */
    public TemporaryFolder(File parentFolder) {
        this.parentFolder = parentFolder;
        this.assureDeletion = false;
    }

    /**
     * Create a {@link TemporaryFolder} initialized with
     * values from a builder.
     */
    protected TemporaryFolder(Builder builder) {
        this.parentFolder = builder.parentFolder;
        this.assureDeletion = builder.assureDeletion;
    }

    /**
     * Returns a new builder for building an instance of {@link TemporaryFolder}.
     *
     * @since 4.13
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an instance of {@link TemporaryFolder}.
     * 
     * @since 4.13
     */
    public static class Builder {
        private File parentFolder;
        private boolean assureDeletion;

        protected Builder() {
        }

        /**
         * Specifies which folder to use for creating temporary resources.
         * If {@code null} then system default temporary-file directory is
         * used.
         *
         * @return this
         */
        public Builder parentFolder(File parentFolder) {
            this.parentFolder = parentFolder;
            return this;
        }

        /**
         * Setting this flag assures that no resources are left undeleted. Failure
         * to fulfill the assurance results in failure of tests with an
         * {@link AssertionError}.
         *
         * @return this
         */
        public Builder assureDeletion() {
            assureDeletion = true;
            return this;
        }

        /**
         * Builds a {@link TemporaryFolder} instance using the values in this builder.
         */
        public TemporaryFolder build() {
            return new TemporaryFolder(this);
        }
    }

    @Override
    protected void before() throws Throwable {
        create();
    }

    @Override
    protected void after() {
        delete();
    }

    // testing purposes only

    /**
     * for testing purposes only. Do not use.
     */
    public void create() throws IOException {
        folder = createTemporaryFolderIn(parentFolder);
    }

    /**
     * Returns a new fresh file with the given name under the temporary folder.
     */
    public File newFile(String fileName) throws IOException {
        File file = new File(getRoot(), fileName);
        if (!file.createNewFile()) {
            throw new IOException(
            "a file with the name \'" + fileName + "\' already exists in the test folder");
        }
        return file;
    }

    /**
     * Returns a new fresh file with a random name under the temporary folder.
     */
    public File newFile() throws IOException {
        return File.createTempFile(TMP_PREFIX, null, getRoot());
    }

    /**
     * Returns a new fresh folder with the given path under the temporary
     * folder.
     */
    public File newFolder(String path) throws IOException {
        return newFolder(new String[]{path});
    }

    /**
     * Returns a new fresh folder with the given paths under the temporary
     * folder. For example, if you pass in the strings {@code "parent"} and {@code "child"}
     * then a directory named {@code "parent"} will be created under the temporary folder
     * and a directory named {@code "child"} will be created under the newly-created
     * {@code "parent"} directory.
     */
    public File newFolder(String... paths) throws IOException {
        if (paths.length == 0) {
            throw new IllegalArgumentException("must pass at least one path");
        }
        File file = getRoot();
        for (String path : paths) {
            file = new File(file, path);
        }
        if (!file.mkdirs()) {
            throw new IOException("a folder failed to be created");
        }
        return file;
    }

    /**
     * Returns a new fresh folder with a random name under the temporary folder.
     */
    public File newFolder() throws IOException {
        return createTemporaryFolderIn(getRoot());
    }

    private static File createTemporaryFolderIn(File parentFolder) throws IOException {
        try {
            return createTemporaryFolderWithNioApi(parentFolder);
        } catch (ClassNotFoundException ignore) {
            // Continue and try with java.io.File API
        } catch (NoSuchMethodException ignore) {
            // Continue and try with java.io.File API
        } catch (InvocationTargetException ignore) {
            // Continue and try with java.io.File API
        } catch (IllegalAccessException ignore) {
            // Continue and try with java.io.File API
        }
        return createTemporaryFolderWithFileApi(parentFolder);
    }

    private static File createTemporaryFolderWithNioApi(File parentFolder) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> files = Class.forName("java.nio.file.Files");
        Class<?> path = Class.forName("java.nio.file.Path");
        Class<?> fileAttribute = Class.forName("java.nio.file.attribute.FileAttribute");
        
        Object dir;
        if (parentFolder != null) {
            Class<?> paths = Class.forName("java.nio.file.Paths");
            Method method = paths.getMethod("get", String.class, String[].class);
            String[] pathParts = { parentFolder.getPath() };
            dir = method.invoke(null, pathParts);
        } else {
            dir = files.getDeclaredMethod("createTempDirectory", String.class, fileAttribute.getClasses()). //
            invoke(null, TMP_PREFIX, new Class<?>[0]);
        }
        
        return (File) path.cast(dir).getDeclaredMethod("toFile").invoke(path.cast(dir));
    }

    private static File createTemporaryFolderWithFileApi(File parentFolder) throws IOException {
        File createdFolder = null;
        for (int i = 0; i < TEMP_DIR_ATTEMPTS; ++i) {
            String suffix = ".tmp";
            try {
                createdFolder = File.createTempFile(TMP_PREFIX, suffix, parentFolder);
            } catch (IOException e) {
                throw new RuntimeException("Unable to create temporary directory, " + createdFolder, e);
            }
            
            if (!createdFolder.delete()) {
                throw new IOException(
                "Unable to delete temporary file, " + createdFolder);
            }
            
            if (createdFolder.mkdir()) {
                return createdFolder;
            }
        }
        throw new IOException("Unable to create temporary directory in: " + parentFolder);
    }

    /**
     * @return the location of this temporary folder.
     */
    public File getRoot() {
        if (folder == null) {
            throw new IllegalStateException(
            "the temporary folder has not yet been created");
        }
        return folder;
    }

    /**
     * Delete all files and folders under the temporary folder. Usually not
     * called directly, since it is automatically applied by the {@link Rule}.
     *
     * @throws AssertionError if unable to clean up resources
     * and deletion of resources is assured.
     */
    public void delete() {
        if (!tryDelete()) {
            if (assureDeletion) {
                fail("Unable to clean up temporary folder " + folder);
            }
        }
    }

    /**
     * Tries to delete all files and folders under the temporary folder and
     * returns whether deletion was successful or not.
     *
     * @return {@code true} if all resources are deleted successfully,
     *         {@code false} otherwise.
     */
    private boolean tryDelete() {
        if (folder == null) {
            return true;
        }
        
        return recursiveDelete(folder);
    }

    private boolean recursiveDelete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File each : files) {
                    if (!recursiveDelete(each)) {
                        return false;
                    }
                }
            }
        }
        return file.delete();
    }
}
