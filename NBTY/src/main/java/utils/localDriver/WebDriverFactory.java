package utils.localDriver;

import org.openqa.selenium.WebDriver;
import utils.Config;

import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public class WebDriverFactory {

    public WebDriver getDriver(String browserType) {

        WebDriverCreator driverCreator;

        switch (browserType){
            case "firefox":
                driverCreator = new FirefoxDriverCreator();
                break;
            case "chrome":
                driverCreator = new ChromeDriverCreator();
                break;
            default:
                throw new RuntimeException("");
        }

        WebDriver driver = driverCreator.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getConfigInstance().getUrl());

        return driver;
    }
}
