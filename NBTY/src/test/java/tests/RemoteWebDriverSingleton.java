package tests;

import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Siarhei Bolka on 5/28/2015.
 */
public class RemoteWebDriverSingleton {

    private static RemoteWebDriverSingleton driver;

    private RemoteWebDriverSingleton() {}

    public static RemoteWebDriverSingleton getRemoteWebDriverInstance() {
        if(null == driver) {
            driver = new RemoteWebDriverSingleton();
        }
        return driver;
    }

    public static void closeWebBrowser(){
//        driver.quit();
//        driver = null;
    }
}

