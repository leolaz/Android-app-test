package com.epam.lab.activities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainActivity extends ActivityObject {

    private static Logger logger = LogManager.getLogger(MainActivity.class);

    @FindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
    private WebElement webViewBtn;

    public void openWebViewActivity() {
        logger.info("Click on button 'with chrome icon'");
        webViewBtn.click();
    }

}
