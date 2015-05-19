package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class OrderConfirmationPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(.,' Your order has been received. ')]")
    private WebElement elementOnOrderConfirmationPage;

    public OrderConfirmationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isOrderConfirmationMessagePresent()
    {
        return elementOnOrderConfirmationPage.isDisplayed();
    }
}
