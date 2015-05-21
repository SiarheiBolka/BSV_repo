import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static pages.CheckoutDeliveryPaymentPage.PaymentDetails;

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

    HashMap<PaymentDetails, String> paymentDetails = new HashMap<PaymentDetails, String>();

    @BeforeTest
    public void setup()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hb-dev3.oracleoutsourcing.com/");
    }

    @AfterTest
    public void clean()
    {
        driver.quit();
    }

    public void checkoutTest()
    {
        //TODO use enum
        paymentDetails.put(PaymentDetails.DELIVERY_TYPE, CheckoutDeliveryPaymentPage.DeliveryType.DELIVERY.getType());
        paymentDetails.put(PaymentDetails.POST_CODE, "1");
        paymentDetails.put(PaymentDetails.PAYMENT_TYPE, CheckoutDeliveryPaymentPage.PaymentType.CARD.getType());
        paymentDetails.put(PaymentDetails.CARD_TYPE, CheckoutDeliveryPaymentPage.CardType.VISA.getType());
        paymentDetails.put(PaymentDetails.CARD_NUMBER, "4444333322221145");
        paymentDetails.put(PaymentDetails.EXPIRY_MONTH, "05");
        paymentDetails.put(PaymentDetails.EXPIRY_YEAR, "18");
        paymentDetails.put(PaymentDetails.CARD_SECURITY_CODE, "123");
        paymentDetails.put(PaymentDetails.PASSWORD, "password");

        homePage = new HomePage(driver);
        landingPage = homePage.openSubcategoryBathing();
        productDetailsPage = landingPage.openPDPOfProduct("60038772");
        basketPage = productDetailsPage.addProductToBasket();
        checkoutWelcomePage = basketPage.clickButtonCheckout();
        checkoutAboutYouPage = checkoutWelcomePage.setEmail("testmailbsv@mailinator.com");
        checkoutDeliveryPaymentPage = checkoutAboutYouPage.setFNameAndLName("userFirstName", "userLastName");
        orderConfirmationPage = checkoutDeliveryPaymentPage.setPaymentDetails(paymentDetails);

        Assert.assertEquals(orderConfirmationPage.isOrderConfirmationMessagePresent(), true,
                "Error: 'Order confirmation' page is not opened");
    }

}

