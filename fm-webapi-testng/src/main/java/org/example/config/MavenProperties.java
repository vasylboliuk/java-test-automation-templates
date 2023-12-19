package org.example.config;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.FileUtil;

public class MavenProperties {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String MAVEN_PROPERTIES = "/maven.properties";
    private static final String ENVIRONMENT_PROPERTY = "ExecutionEnvironment";
    private final Properties properties;

    private MavenProperties() {
        properties = FileUtil.readFileAsProperties(MAVEN_PROPERTIES);
    }

    public static Properties getMavenProperties() {
        return SingletonHolder.INSTANCE.properties;
    }

    private static class SingletonHolder {

        static final MavenProperties INSTANCE = new MavenProperties();

        private SingletonHolder() {
            //empty
        }
    }

    /**
     * Get MavenProperties - ExecutionEnvironment.
     * @return - ExecutionEnvironment
     */
    public static String getCurrentEnvironment() {
        return getMavenProperties().getProperty(ENVIRONMENT_PROPERTY);
    }


}
