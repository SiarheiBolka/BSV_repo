import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Siarhei Bolka on 5/22/2015.
 */
public class RemoteDriverTest {

    private final String SO = "http://www.stackoverflow.com";
    private final String HUB = "http://localhost:4444/wd/hub";

    @Test(threadPoolSize = 2, invocationCount = 4, timeOut = 30 * 1000)
    public void oneCanExecuteRemoteTest() throws MalformedURLException
    {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);

        WebDriver driver = new RemoteWebDriver(new URL(HUB), dc);

        driver.get(SO);
        driver.findElement(By.id("nav-users")).click();

    }


}
