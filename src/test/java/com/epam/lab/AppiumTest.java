package com.epam.lab;

import com.epam.lab.activities.MainActivity;
import com.epam.lab.activities.WebViewActivity;
import com.epam.lab.enums.Car;
import org.junit.After;
import org.junit.Test;

import static com.epam.lab.utils.AndroidDriverUtils.close;

public class AppiumTest {

    private String name = "Appium";
    private Car car = Car.MERCEDES;

    @Test
    public void appTest() {
        MainActivity mainPage = new MainActivity();
        mainPage.openWebViewActivity();

        WebViewActivity webViewActivity = new WebViewActivity();
        webViewActivity.inputName(name);
        webViewActivity.selectCar(car);
        webViewActivity.submit();
        webViewActivity.checkValues(name, car);
    }

    @After
    public void tearDown() {
        close();
    }
}
