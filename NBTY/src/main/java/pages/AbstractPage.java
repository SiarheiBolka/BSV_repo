package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */

public abstract class AbstractPage
{

    protected final WebDriver driver;

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }

    public Boolean isElementPresent(By locator)
    {
        return driver.findElements(locator).size() > 0;
    }

}