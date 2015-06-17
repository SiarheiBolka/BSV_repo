package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import utils.localDriver.WebDriverSingleton;

import java.net.MalformedURLException;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public class SearchTest {

    HomePage homePage;
    SearchPage searchPage;

    @AfterTest
    public void clean() {
        WebDriverSingleton.getWebDriverInstance().quit();
    }

    @Test(threadPoolSize = 1, invocationCount = 1, timeOut = 30 * 10000, groups = { "searchtest" })
    public void searchTest() throws MalformedURLException {
        homePage = new HomePage();
        searchPage = homePage.search("milk");

        Assert.assertEquals(searchPage.areProductsFounded(), true,
                "Error: Products are not founded");

    }
}
