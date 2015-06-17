package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.localDriver.WebDriverSingleton;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class ProductDetailsPage {

    @FindBy(id = "cartbtn")
    private WebElement buttonAddToBasket;

    @FindBy(linkText = "View basket")
    private WebElement linkViewBasket;

    public ProductDetailsPage()
    {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public void clickButtonAddToBasket ()
    {
        buttonAddToBasket.click();
    }

    public void clickLinkViewBasket ()
    {
        linkViewBasket.click();
    }

    public BasketPage addProductToBasket()
    {
        clickButtonAddToBasket();
        clickLinkViewBasket();
        return new BasketPage();
    }
}
