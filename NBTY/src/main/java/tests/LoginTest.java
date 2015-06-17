package tests;

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
import utils.Config;
import utils.PropertyFileReader;
import utils.localDriver.WebDriverSingleton;
import utils.remoteDriver.RemoteWebDriverSingleton;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */

public class LoginTest {

    HomePage homePage;
    LoginPage loginPage;

    @AfterTest
    public void clean()
    {
        WebDriverSingleton.getWebDriverInstance().quit();
    }

    @Test(threadPoolSize = 1, invocationCount = 1, timeOut = 30 * 10000, groups = { "logintest" })
    public void loginTest() {
        homePage = new HomePage();
        loginPage = homePage.openLoginPage();
        homePage = loginPage.login(Config.getConfigInstance().getUserName(), Config.getConfigInstance().getPassword());

        Assert.assertEquals(homePage.isUserLoggedIn(), true,
                "Error: User is not logged in");
    }
}
