package com.nbty.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/25/2015.
 */
public class MyAccountPage extends PageObject {


    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement pageTitle;

    public void assertIsOpened() {
        element(pageTitle).shouldContainOnlyText("My Account");
    }
}
