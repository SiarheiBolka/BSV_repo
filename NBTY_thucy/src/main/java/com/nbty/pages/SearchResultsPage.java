package com.nbty.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/26/2015.
 */
public class SearchResultsPage extends PageObject {

    @FindBy(xpath = "//h1[contains(@class, 'page-title') and contains(text(), 'You searched for')] ")
    WebElement pageTitle;

    @FindBy(xpath = "//article[contains(@class, 'prod-teaser-item')]")
    WebElementFacade productsFounded;

    public void assertIsOpened() {
        element(pageTitle).isDisplayed();
    }

    public void areProductsDisplayed() {
        productsFounded.isDisplayed();
    }
}
