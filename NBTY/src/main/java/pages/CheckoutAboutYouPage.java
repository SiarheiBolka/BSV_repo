package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.localDriver.WebDriverSingleton;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class CheckoutAboutYouPage {

    @FindBy(id = "checkout_form_firstname")
    private WebElement firstName;

    @FindBy(id = "checkout_form_lastname")
    private WebElement lastName;

    @FindBy(id = "checkout_form_no_account")
    private WebElement checkboxNoThanks;

    @FindBy(xpath = "//input[@value='Continue >']")
    private WebElement buttonContinue;


    public CheckoutAboutYouPage()
    {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public void setFirstName(String fName)
    {
        firstName.sendKeys(fName);
    }

    public void setLastName(String lName)
    {
        lastName.sendKeys(lName);
    }

    public void selectCheckboxNoThanks()
    {
        checkboxNoThanks.click();
    }

    public void clickButtonContinue()
    {
        buttonContinue.click();
    }

    public CheckoutDeliveryPaymentPage setFNameAndLName(String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
        selectCheckboxNoThanks();
        clickButtonContinue();
        return new CheckoutDeliveryPaymentPage();
    }
}
