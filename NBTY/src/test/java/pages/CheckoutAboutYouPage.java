package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class CheckoutAboutYouPage {

    private WebDriver driver;

    @FindBy(id = "checkout_form_firstname")
    private WebElement firstName;

    @FindBy(id = "checkout_form_lastname")
    private WebElement lastName;

    @FindBy(id = "checkout_form_no_account")
    private WebElement checkboxNoThanks;

    @FindBy(xpath = "//input[@value='Continue >']")
    private WebElement buttonContinue;


    public CheckoutAboutYouPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setFirstName()
    {
        firstName.sendKeys("fname");
    }

    public void setLastName()
    {
        lastName.sendKeys("lname");
    }

    public void selectCheckboxNoThanks()
    {
        checkboxNoThanks.click();
    }

    public void clickButtonContinue()
    {
        buttonContinue.click();
    }
}
