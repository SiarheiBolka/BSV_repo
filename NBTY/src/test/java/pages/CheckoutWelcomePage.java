package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class CheckoutWelcomePage {

    private WebDriver driver;

    @FindBy(id = "checkout_form_email")
    private WebElement email;

    //By email = By.id("checkout_form_email");

    @FindBy(name = "/atg/userprofiling/ProfileFormHandler.continue")
    private WebElement buttonContinue;
    //By buttonContinue = By.name("/atg/userprofiling/ProfileFormHandler.continue");

    public CheckoutWelcomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public CheckoutAboutYouPage setEmail (String mail)
    {
        //TODO Remove findElements - done
        email.sendKeys(mail);
        buttonContinue.click();
        return new CheckoutAboutYouPage(driver);
    }

}
