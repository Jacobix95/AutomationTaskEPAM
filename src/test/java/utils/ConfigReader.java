package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("config.properties file not found in classpath.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file.", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome").toLowerCase();
    }
}
