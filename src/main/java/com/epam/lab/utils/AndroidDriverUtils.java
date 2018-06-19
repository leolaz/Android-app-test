package com.epam.lab.utils;

import com.epam.lab.enums.DriverContext;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.lab.utils.PropertyReader.getProperty;

public class AndroidDriverUtils {

    private static Logger logger = LogManager.getLogger(AndroidDriverUtils.class);

    private static ThreadLocal<AndroidDriver> driver = ThreadLocal.withInitial(() -> {
        AndroidDriver androidDriver = null;
        try {
            androidDriver = new AndroidDriver(new URL(getProperty("server_url")), CapabilityReader.read(getProperty("capabilities_path")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return androidDriver;
    });

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void load(String URL) {
        getDriver().get(URL);
    }

    public static void close() {
        driver.get().quit();
        driver.remove();
    }

    public static WebDriverWait newWait() {
        return new WebDriverWait(getDriver(), 10);
    }

    public static void contextTo(DriverContext context){
        logger.info("Change driver context to " + context.getValue());
        getDriver().context(context.getValue());
    }

}
