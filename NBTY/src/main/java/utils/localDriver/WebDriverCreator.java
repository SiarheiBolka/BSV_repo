package utils.localDriver;

import org.openqa.selenium.WebDriver;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public abstract class WebDriverCreator {

    protected WebDriver driver;

    public abstract WebDriver createDriver();
}
