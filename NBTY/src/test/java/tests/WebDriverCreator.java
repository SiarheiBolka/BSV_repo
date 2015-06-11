package tests;

import org.openqa.selenium.WebDriver;

/**
 * Created by Siarhei Bolka on 5/29/2015.
 */
public abstract class WebDriverCreator {

    protected WebDriver driver;

    public abstract WebDriver createDriver();
}
