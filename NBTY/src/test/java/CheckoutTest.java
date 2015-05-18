import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */

@Test(groups = { "checkouttest" })
public class CheckoutTest {

    WebDriver driver;

    HomePage homePage;
    LandingPage landingPage;
    ProductDetailsPage productDetailsPage;
    BasketPage basketPage;
    CheckoutWelcomePage checkoutWelcomePage;
    CheckoutAboutYouPage checkoutAboutYouPage;
    CheckoutDeliveryPaymentPage checkoutDeliveryPaymentPage;
    OrderConfirmationPage orderConfirmationPage;

    Map<String, String> paymentDetails = new HashMap<String, String>();

    @BeforeTest
    public void setup()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hb-preprod.oracleoutsourcing.com/");
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }

    public void checkoutTest()
    {
        paymentDetails.put("paymentType", "c");
        paymentDetails.put("cardNumber", "4444333322221145");
        paymentDetails.put("expiryMonth", "05");
        paymentDetails.put("expiryYear", "18");
        paymentDetails.put("cardSecurityCode", "123");
        paymentDetails.put("password", "password");

        homePage = new HomePage(driver);
        landingPage = homePage.openSubcategoryBathing();
        productDetailsPage = landingPage.openPDP();
        basketPage = productDetailsPage.addProductToBasketFromPDP();
        checkoutWelcomePage = basketPage.clickButtonCheckout();
        checkoutAboutYouPage = checkoutWelcomePage.setEmail("testmailbsv@mailinator.com");
        checkoutDeliveryPaymentPage = checkoutAboutYouPage.setFNameAndLName("userFirstName", "userLastName");
        orderConfirmationPage = checkoutDeliveryPaymentPage.setPaymentDetails(paymentDetails);

        Assert.assertEquals(orderConfirmationPage.getElementOnOrderConfirmationPage().isDisplayed(), true,
                "Error: 'Order confirmation' page is not opened");
    }

}
