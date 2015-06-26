package com.nbty.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/26/2015.
 */

@DefaultUrl("http://hb-dev3.oracleoutsourcing.com")
public class HomePage extends PageObject {

    @FindBy(xpath = "//section[contains(@class, 'large-vp banner hero-banner js')]")
    private WebElement banner;

    @FindBy(id = "sitesearch")
    private WebElementFacade searchField;

    @FindBy(className = "orangeSubmit")
    private  WebElementFacade goButton;


    public void fillInSearchField() {
        element(searchField).type("milk");
    }

    public void pressGoButton() {
        element(goButton).click();
    }

    public void assertIsOpened() {
        element(banner).isDisplayed();
    }
}
