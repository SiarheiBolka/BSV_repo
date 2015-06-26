package com.nbty.steps;

import com.nbty.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EndUserSteps extends ScenarioSteps {

    LoginPage loginPage;
    MyAccountPage myAccountPage;
    GlobalHeaderFooter globalHeaderFooter;
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @Step
    public void openLoginPage() {
        loginPage.open();
        getDriver().navigate().refresh();
    }

    @Step
    public void openHomePage() {
        homePage.open();
        getDriver().navigate().refresh();
    }

    @Step
    public void fillInEmail() {
        loginPage.fillInEmail();
    }

    @Step
    public void fillInPassword() {
        loginPage.fillInPassword();
    }

    @Step
    public void pressSignInButton() {
        loginPage.pressSignInButton();
    }

    @Step
    public void assertOnMyAccountPage() {
        myAccountPage.assertIsOpened();
    }

    @Step
    public void assertLoggedIn() {
        globalHeaderFooter.isLinkLogoutPresent();
    }

    @Step
    public void fillInSearchField() {
        homePage.fillInSearchField();
    }

    @Step
    public void pressGoButton() {
        homePage.pressGoButton();
    }

    @Step
    public void assertOnSearchResultsPage() {
        searchResultsPage.assertIsOpened();
    }

    @Step
    public void assertProductsDisplayed() {
        searchResultsPage.areProductsDisplayed();
    }


}