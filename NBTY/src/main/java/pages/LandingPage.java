package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.localDriver.WebDriverSingleton;

import java.util.List;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class LandingPage {

    @FindBy(xpath = "//div[contains(@class, 'prod-list-item')]")
    List<WebElement> productList;

    public LandingPage()
    {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public ProductDetailsPage openPDPOfProduct(String productId){
        for(WebElement element : productList){
            if(element.getAttribute("id").toString().equals(productId)){
                element.click();
                return new ProductDetailsPage();
            }
        }
        throw new RuntimeException("Product '"+ productId +"' is NOT found.");
    }

}
