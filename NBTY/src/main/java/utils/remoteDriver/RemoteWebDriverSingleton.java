package utils.remoteDriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Config;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public abstract class RemoteWebDriverSingleton {

    private static RemoteWebDriver driver;

    private RemoteWebDriverSingleton() {}

    public static RemoteWebDriver getRemoteWebDriverInstance() throws MalformedURLException {
        if(null == driver) {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(Config.getConfigInstance().getBrowserName());
            dc.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(Config.getConfigInstance().getHub()), dc);
        }
        return driver;
    }

    public static void closeWebBrowser(){
        driver.quit();
        driver = null;
    }
}
