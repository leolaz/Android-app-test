package com.epam.lab.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    private static Logger logger = LogManager.getLogger(PropertyReader.class);

    static {
        properties = new Properties();
        String path = "src/main/resources/test.properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            logger.error("Put property file in \"" + path + "\"");
            logger.catching(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
