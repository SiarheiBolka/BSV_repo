import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */

public class LoginTest {

    private final String HUB = PropertyFileReader.loadPropertiesFile().getProperty("HUB");
    private final String ENV = PropertyFileReader.loadPropertiesFile().getProperty("URL");

    WebDriver driver;

    HomePage homePage, homePageAfterLogin;
    LoginPage loginPage;


    @AfterTest
    public void clean()
    {
        driver.quit();
    }

    @Parameters({ "browserName" })
    @Test(threadPoolSize = 1, invocationCount = 1, timeOut = 30 * 10000, groups = { "logintest" })
    public void checkoutTest(String browserName) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(browserName);
        dc.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(HUB), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ENV);

        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        homePageAfterLogin = loginPage.login("mail4bsv@gmail.com", "123456");

        Assert.assertEquals(homePageAfterLogin.isUserLoggedIn(), true,
                "Error: User is not logged in");
    }
}
