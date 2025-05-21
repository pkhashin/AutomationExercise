package com.ecommerce.config;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesManager {

    private static final Properties prop = new Properties();
    private static boolean isLoaded = false;
    private PropertiesManager() {
    }
    public static Properties initProp() {
        if (!isLoaded)
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
                prop.load(fis);
                isLoaded = true;
            } catch (Exception e) {
                throw new RuntimeException("Failed to load properties file: ");
            }
        return prop;
    }

    public static String get(String key) {
        return initProp().getProperty(key);
    }
    public static String get(String key, String defaultValue) {
        return initProp().getProperty(key, defaultValue);
    }
    public static void set(String key, String value) {
        initProp().setProperty(key, value);
    }

}
