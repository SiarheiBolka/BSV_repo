package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class LandingPage {

    private WebDriver driver;

/*    @FindBy(id = "60083074")
    private WebElement product;*/

    @FindBy(xpath = "//li[contains(@class, 'main-nav-item')]")
    List<WebElement> productList;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


/*    public ProductDetailsPage openPDP(String productId)
    {
        //TODO add list of products - done
        product.click();
        return new ProductDetailsPage(driver);
    }*/


    public ProductDetailsPage openPDPOfProduct(int productId){
        for(WebElement element : productList){
            if(element.getAttribute("id").equals(productId)){
                element.click();
                return new ProductDetailsPage(driver);
            }
        }
        throw new RuntimeException("Product '"+ productId +"' is NOT found.");
    }

}
