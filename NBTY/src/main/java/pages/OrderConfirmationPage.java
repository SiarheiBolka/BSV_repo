package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.localDriver.WebDriverSingleton;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class OrderConfirmationPage {

    Wait<WebDriver> wait;

    @FindBy(className = "act-print")
    private WebElement elementOnOrderConfirmationPage;

    public OrderConfirmationPage()
    {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
        this.wait = new FluentWait<WebDriver>(WebDriverSingleton.getWebDriverInstance())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public boolean isOrderConfirmationMessagePresent()
    {
        wait.until(ExpectedConditions.visibilityOf(elementOnOrderConfirmationPage));
        System.out.println(elementOnOrderConfirmationPage.isDisplayed());
        return elementOnOrderConfirmationPage.isDisplayed();
    }
}
