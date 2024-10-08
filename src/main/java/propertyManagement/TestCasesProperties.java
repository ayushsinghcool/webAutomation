package propertyManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestCasesProperties {

    private TestCasesProperties(){

    }
    private static final String PROPERTIES_FILE = "config/TestCases.properties";
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(TestCasesProperties.class);

    static {

        logger.info("Loading Test Cases Property");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            logger.error("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");

        }

        try {
            properties.load(propertiesFile);
        } catch (IOException e) {
            logger.error("Cannot load properties file :'" + PROPERTIES_FILE + "'");
        }
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static String getTestCase(String key) {
        properties.getProperty(key);
        String keyValue="";
        keyValue = key + ": " + properties.getProperty(key);
        return keyValue;
    }

    public static void setProperty(String name, String value) {
        properties.setProperty(name, value);
    }
}
