package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class AndroidDriverSingleton {

    private static AndroidDriver driver;

    private AndroidDriverSingleton() {}

    public static AndroidDriver createDriver() {

        if(null == driver) {
            URL seleniumGridUrl = null;
            String myApp = "d:/Android/platform-tools/com.basecamp.app.apk";

            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            dc.setCapability(MobileCapabilityType.APP, myApp);

            try {
                seleniumGridUrl = new URL("http://127.0.0.1:4723/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            driver = new AndroidDriver(seleniumGridUrl, dc);
            driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        }

        return driver;
    }

    public static void closeAndroidDriver(){
        driver.quit();
        driver = null;
    }
}
