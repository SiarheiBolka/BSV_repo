import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */

@Test(groups = { "checkouttest" })
public class CheckoutTest {

    WebDriver driver;

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    public void checkoutTest() {
        driver = new FirefoxDriver();
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.clickOnCategoryPersonalCare();
        homePage.clickOnCategoryPersonalCare();
        homePage.clickOnCategoryBathing();
        System.out.println(driver.getTitle());
        LandingPage landingPage = new LandingPage(driver);


    }

}
