package tests;

import org.openqa.selenium.WebDriver;

/**
 * Created by Siarhei Bolka on 5/28/2015.
 */
public class  WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getWebDriverInstance() {
        if(null == driver) {
            WebDriverCreator creator = new FirefoxDriverCreator();
            driver = creator.createDriver();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        driver.quit();
        driver = null;
    }
}
