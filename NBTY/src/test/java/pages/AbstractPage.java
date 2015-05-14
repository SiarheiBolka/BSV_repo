package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */

public abstract class AbstractPage
{

    protected WebDriver driver;

    //public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}