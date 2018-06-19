package com.epam.lab.activities;

import org.openqa.selenium.support.PageFactory;

import static com.epam.lab.utils.AndroidDriverUtils.getDriver;

abstract class ActivityObject {

    ActivityObject(){
        PageFactory.initElements(getDriver(), this);
    }
}
