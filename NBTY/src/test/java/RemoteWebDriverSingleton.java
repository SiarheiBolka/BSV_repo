import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Siarhei Bolka on 5/28/2015.
 */
public class RemoteWebDriverSingleton {

    private static RemoteWebDriver driver;

    private RemoteWebDriverSingleton() {}

    public static RemoteWebDriver getRemoteWebDriverInstance() {
        if(null == driver) {
            //driver = new RemoteWebDriver();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        driver.quit();
        driver = null;
    }
}

