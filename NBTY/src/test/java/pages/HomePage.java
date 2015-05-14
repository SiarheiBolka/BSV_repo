package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class HomePage{

    private final String BASE_URL = "http://hb-preprod.oracleoutsourcing.com/";
    private WebDriver driver;

    @FindBy(linkText = "Personal Care")
    private WebElement categoryPersonalCare;

    @FindBy(linkText = "Bathing")
    private WebElement categoryBathing;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openPage()
    {
        this.driver.get(BASE_URL);
    }

    public void clickOnCategoryPersonalCare()
    {
        categoryPersonalCare.click();
    }

    public void clickOnCategoryBathing()
    {
        categoryBathing.click();
//        return new LandingPage(this.driver);
    }

}
