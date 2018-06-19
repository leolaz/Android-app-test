package com.epam.lab.activities;

import com.epam.lab.enums.Car;
import com.epam.lab.enums.DriverContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.epam.lab.utils.AndroidDriverUtils.*;

public class WebViewActivity extends ActivityObject {

    private static Logger logger = LogManager.getLogger(WebViewActivity.class);

    @FindBy(id = "name_input")
    private WebElement nameInput;

    @FindBy(css = "select[name=\"car\"]")
    private WebElement carSelector;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElement submitBtn;

    @FindBy(css = "body")
    private WebElement body;

    @FindBy(css = "h1")
    private WebElement loadCheck;

    public void inputName(String name) {
        contextTo(DriverContext.WEBVIEW);
        newWait().until(ExpectedConditions.visibilityOf(nameInput));

        logger.info("Send keys to Name input");
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void selectCar(Car car) {
        logger.info("Click on Car selector");
        carSelector.click();

        contextTo(DriverContext.NATIVE);
        logger.info("Select car [" + car.name() + "]");
        getDriver().findElement(By.xpath("//android.widget.ListView/android.widget.CheckedTextView[" + car.getValue() + "]")).click();
    }

    public void submit() {
        contextTo(DriverContext.WEBVIEW);
        logger.info("Click on Submit button");
        submitBtn.click();
    }

    public void checkValues(String name, Car car) {
        newWait().until(ExpectedConditions.visibilityOf(loadCheck));
        logger.info("Checking containing [" + name + "] and [" + car.name() + "] in result page");
        Assert.assertTrue(body.getText().contains(name) && body.getText().contains(car.name().toLowerCase()));
    }

}
