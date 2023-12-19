package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FileUtil {

    private static final Logger LOGGER = LogManager.getLogger();

    private FileUtil() {
        // default constructor
    }

    /**
     * Read Properties file by file path.
     * @param filePath - file path in resources
     * @return - Properties
     */
    public static Properties readFileAsProperties(String filePath) {
        Properties props = new Properties();
        try (InputStream myIs = FileUtil.class.getResourceAsStream(filePath)) {
            props.load(myIs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    /**
     * Load file content by file path from resources.
     *
     * @param path path to a file
     * @return String file contents
     */
    public static String loadFileAsString(String path) {
        LOGGER.info("Load file as String from resources: {}", path);
        String fileContents = null;
        try (InputStream inputStream = FileUtil.class.getResourceAsStream(path)) {
//            fileContents = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            fileContents = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return fileContents;
    }

    /**
     * Gets an input stream from a file.
     *
     * @param filePath    - path to file
     * @param configClass - loader
     * @return InputStream of located file
     * @throws FileNotFoundException in case if file was not found
     */
    public static InputStream getFileInputStream(String filePath, Class<?> configClass) throws FileNotFoundException {
        InputStream inputStream = configClass.getResourceAsStream(filePath);
        if (inputStream == null) {
            inputStream = new FileInputStream(filePath);
        }
        return inputStream;
    }

}
