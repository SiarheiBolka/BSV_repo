package utils.localDriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Config;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public class ChromeDriverCreator extends WebDriverCreator {

    public  static final String PATH_TO_CHROMEDRIVER = "c:\\chromedriver.exe";

    @Override
    public WebDriver createDriver() {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);

        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_CHROMEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }

        driver = new ChromeDriver(service, dc);
        return driver;
    }
}
