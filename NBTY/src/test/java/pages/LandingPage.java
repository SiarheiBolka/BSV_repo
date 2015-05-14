package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class LandingPage {

    private WebDriver driver;

    public WebElement getProduct() {
        return product;
    }

    @FindBy(id = "60083074")
    private WebElement product;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public Boolean isElementPresent(By locator)
    {
        return driver.findElements(locator).size() > 0;
    }

}
