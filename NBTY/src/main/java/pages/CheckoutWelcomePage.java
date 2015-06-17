package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.localDriver.WebDriverSingleton;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class CheckoutWelcomePage {

    @FindBy(id = "checkout_form_email")
    private WebElement email;

    @FindBy(name = "/atg/userprofiling/ProfileFormHandler.continue")
    private WebElement buttonContinue;

    public CheckoutWelcomePage()
    {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public CheckoutAboutYouPage setEmail (String mail) {
        email.sendKeys(mail);
        buttonContinue.click();
        return new CheckoutAboutYouPage();
    }

}
