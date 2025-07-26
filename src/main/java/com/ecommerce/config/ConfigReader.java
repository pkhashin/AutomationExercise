package com.ecommerce.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;
@Slf4j
public class ConfigReader {
    private static final Logger log = LoggerFactory.getLogger(ConfigReader.class);
    private static final Properties prop = new Properties();
    private static boolean isLoaded = false;
    private ConfigReader() {
    }
    public static Properties initProp() {
        if (!isLoaded)
            try {
                FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
                prop.load(fis);
                isLoaded = true;
                log.info("Configuration properties loaded successfully.");
            } catch (Exception e) {
                throw new RuntimeException("Failed to load properties file: ");
            }
        return prop;
    }

    public static String get(String key) {
        String value=initProp().getProperty(key);
        if(value==null){
            log.warn("Configuration key '{}' not found in config.properties. Returning null.", key);
        }
        return value;

    }
    public static String get(String key, String defaultValue) {
        String value=initProp().getProperty(key, defaultValue);
        return value;
    }
    public static void set(String key, String value) {
        initProp().setProperty(key, value);

    }

}
