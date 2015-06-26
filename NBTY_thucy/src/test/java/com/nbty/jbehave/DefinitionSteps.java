package com.nbty.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.nbty.steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("I am on Login page")
    public void openLoginPage() {
        endUser.openLoginPage();
    }

    @When("Passing successfull authentivation")
    public void login() {
        endUser.fillInEmail();
        endUser.fillInPassword();
        endUser.pressSignInButton();
    }

    @Then("I get My Account: Account overview page with logged in status")
    public void assertLoggedInOnMyAccountPage() {
        endUser.assertOnMyAccountPage();
        endUser.assertLoggedIn();
    }

    @Given("I am on Home page")
    public void openHomePage() {
        endUser.openHomePage();
    }

    @When("searching the product by name")
    public void search() {
        endUser.fillInSearchField();
        endUser.pressGoButton();
    }

    @Then("I see the desired products on Search results page")
    public void assertDesiredProductIsDisplayedOnSearchResultsPage() {
        endUser.assertOnSearchResultsPage();
        endUser.assertProductsDisplayed();
    }

}
