package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class ProductDetailsPage {

    private WebDriver driver;

    @FindBy(id = "cartbtn")
    private WebElement buttonAddToBasket;

    @FindBy(linkText = "View basket")
    private WebElement linkViewBasket;

    public ProductDetailsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickButtonAddToBasket ()
    {
        buttonAddToBasket.click();
    }

    public void clickLinkViewBasket ()
    {
        linkViewBasket.click();
    }

    public BasketPage addProductToBasketFromPDP()
    {
        clickButtonAddToBasket();
        clickLinkViewBasket();
        return new BasketPage(driver);
    }
}
