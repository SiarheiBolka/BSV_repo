package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Config;
import utils.localDriver.WebDriverSingleton;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class BasketPage {

    @FindBy(name = "checkout")
    private WebElement buttonCheckout;

    public BasketPage()
    {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public CheckoutWelcomePage clickButtonCheckout ()
    {
        buttonCheckout.click();
        return new CheckoutWelcomePage();
    }
}
