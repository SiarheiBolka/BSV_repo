import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */

@Test(groups = { "checkouttest" })
public class CheckoutTest {

    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hb-preprod.oracleoutsourcing.com/");

        /*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);*/
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    public void checkoutTest() {

        HomePage homePage = new HomePage(driver);
        homePage.openSubcategoryBathing();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProduct(60083074);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickButtonAddToBasket();
        productDetailsPage.clickLinkViewBasket();

        BasketPage basketPage = new BasketPage(driver);
        basketPage.clickButtonCheckout();

        CheckoutWelcomePage checkoutWelcomePage = new CheckoutWelcomePage(driver);
        checkoutWelcomePage.setEmail();
        checkoutWelcomePage.clickButtonContinue();

        CheckoutAboutYouPage checkoutAboutYouPage = new CheckoutAboutYouPage(driver);
        checkoutAboutYouPage.setFirstName();
        checkoutAboutYouPage.setLastName();
        checkoutAboutYouPage.selectCheckboxNoThanks();
        checkoutAboutYouPage.clickButtonContinue();
        
        CheckoutDeliveryPaymentPage checkoutDeliveryPaymentPage = new CheckoutDeliveryPaymentPage(driver);
        checkoutDeliveryPaymentPage.selectDeliveryMethod("delivery");
        checkoutDeliveryPaymentPage.setPostcode();
        checkoutDeliveryPaymentPage.clickButtonLookUpAddress();
        checkoutDeliveryPaymentPage.SelectValueAddressSearchResult();

/*        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        checkoutDeliveryPaymentPage.submitDeliveryAddress();
        checkoutDeliveryPaymentPage.selectDeliveryOption();
        checkoutDeliveryPaymentPage.selectPaymentMethod('c'); //c=PayByCard, p = PayWithPayPal
        checkoutDeliveryPaymentPage.selectCheckboxUseDeliveryAddress();
        checkoutDeliveryPaymentPage.submitBillingAddress();
        checkoutDeliveryPaymentPage.selectCardType("Visa");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkoutDeliveryPaymentPage.fillPaymentDetails();
        checkoutDeliveryPaymentPage.setFieldPassword();
        checkoutDeliveryPaymentPage.clickButtonSubmit();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertEquals(orderConfirmationPage.getElementOnOrderConfirmationPage().isDisplayed(), true,
                "Error: 'Order confirmation' page is not opened");

    }

}
