package org.example.lr1.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {

    private static AppConfig instance;
    private Properties properties;

    private static final String CONFIG_FILE = "src/main/resources/singleton/config.properties";

    private AppConfig() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "");
    }
}
