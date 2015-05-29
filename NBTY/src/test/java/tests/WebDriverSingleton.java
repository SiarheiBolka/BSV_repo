package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Siarhei Bolka on 5/28/2015.
 */
public class  WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getWebDriverInstance() {
        if(null == driver) {
            WebDriverCreator creator = new ChromeDriverCreator();
            driver = creator.factoryMethod();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        driver.quit();
        driver = null;
    }
}
