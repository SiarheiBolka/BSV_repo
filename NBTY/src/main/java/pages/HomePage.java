package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class HomePage /*extends AbstractPage*/{

    private WebDriver driver;

    @FindBy(linkText = "Personal Care")
    private WebElement categoryPersonalCare;

    @FindBy(xpath = "//li[contains(@class, 'main-nav-item')]")
    List<WebElement> categoryList;

    @FindBy(xpath = "//a[@href=\"/shop/personal-care/bathing/\"]")
    private WebElement subcategoryBathing;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openCategoryPersonalCare() {
        categoryPersonalCare.click();
    }

    public LandingPage openSubcategoryBathing() {
        new Actions(driver).moveToElement(categoryPersonalCare).build().perform();
        new Actions(driver).moveToElement(subcategoryBathing).build().perform();
        new Actions(driver).click(subcategoryBathing).build().perform();
        return new LandingPage(driver);
    }

    public void openCategory(String categoryName){
        for(WebElement element : categoryList){
            if(element.getText().equals(categoryName)){
                element.click();
                return;
            }
        }
        throw new RuntimeException("Category '"+ categoryName +"' is NOT found.");
    }

}
