package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class BasketPage {

    private WebDriver driver;

    @FindBy(name = "checkout")
    private WebElement buttonCheckout;

    public BasketPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickButtonCheckout ()
    {
        buttonCheckout.click();
    }
}
