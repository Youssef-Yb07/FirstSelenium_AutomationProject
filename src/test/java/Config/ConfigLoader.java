package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("Config/config.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("config.properties file not found in resources/Config");
            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    /*
    * Or use instead of the above static block:
    * static {
        try {
            properties = new Properties();
            String projectPath = System.getProperty("user.dir");
            properties.load(Files.newInputStream(Paths.get(projectPath, "src/test/resources/Config/config.properties")));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }
    *
    * */

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
