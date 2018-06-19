package com.epam.lab.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class CapabilityReader {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(CapabilityReader.class);

    public static DesiredCapabilities read(String jsonFilePath) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();

        try {
            Map<String, String> map = new Gson().fromJson(new FileReader(jsonFilePath), mapType);
            map.forEach(capabilities::setCapability);
        } catch (FileNotFoundException e) {
            logger.catching(e);
        }
        return capabilities;
    }
}
