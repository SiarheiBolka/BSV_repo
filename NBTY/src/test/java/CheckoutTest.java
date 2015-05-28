import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static pages.CheckoutDeliveryPaymentPage.PaymentDetails;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */

@Test(threadPoolSize = 1, invocationCount = 2, timeOut = 30 * 10000, groups = { "checkouttest" })
public class CheckoutTest {

    private final String HUB = "http://localhost:4444/wd/hub";
    private final String ENV = "http://hb-dev3.oracleoutsourcing.com/";

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
    public void setup() throws MalformedURLException {
/*        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("firefox");
        dc.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(HUB), dc);*/

        //driver = new FirefoxDriver();
        driver = WebDriverSingleton.getWebDriverInstance();
/*        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();*/

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ENV);
    }

    @AfterTest
    public void clean()
    {
       // driver.quit();
        WebDriverSingleton.closeWebBrowser();
    }


    public void checkoutTest() {
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

