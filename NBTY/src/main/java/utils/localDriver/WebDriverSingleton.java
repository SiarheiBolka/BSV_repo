package utils.localDriver;

import org.openqa.selenium.WebDriver;
import utils.Config;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public abstract class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getWebDriverInstance() {
        if(null == driver) {
            WebDriverFactory factory = new WebDriverFactory();
            driver = factory.getDriver(Config.getConfigInstance().getBrowserName());
        }
        return driver;
    }

    public static void closeWebBrowser(){
        driver.quit();
        driver = null;
    }
}
