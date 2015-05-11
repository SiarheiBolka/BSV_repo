import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/6/2015.
 */
public class Login {
    @Test(groups = { "login" })
    public static void loginByUser() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://hb-preprod.oracleoutsourcing.com/");

        WebElement myAccLink;
        myAccLink = driver.findElement(By.className("lnk-my-account"));
        myAccLink.click();

        WebElement email;
        email = driver.findElement(By.id("frm_login_email"));
        email.sendKeys("mail4bsv@gmail.com");

        WebElement password;
        password = driver.findElement(By.id("frm_login_password"));
        password.sendKeys("123456");

        WebElement signInButton;
        signInButton = driver.findElement(By.name("/atg/userprofiling/ProfileFormHandler.login"));
        signInButton.click();

        WebElement logout;
        logout = driver.findElement(By.linkText("Logout"));
        Assert.assertEquals(logout.isDisplayed(), true, "Error: User is not logged in");

        WebElement categoryPersonalCare;
        categoryPersonalCare = driver.findElement(By.linkText("Personal Care"));
        categoryPersonalCare.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        categoryPersonalCare.click();

        WebElement categoryBathing;
        categoryBathing = driver.findElement(By.linkText("Bathing"));
        categoryBathing.click();

        WebElement product;
        product = driver.findElement(By.id("60083074"));
        product.click();

        WebElement addToBasketButton;
        addToBasketButton = driver.findElement(By.id("cartbtn"));
        addToBasketButton.click();

        WebElement viewBasketLink;
        viewBasketLink = driver.findElement(By.linkText("View basket"));
        Assert.assertEquals(viewBasketLink.isDisplayed(), true, "Error: Basket is not opened");
        viewBasketLink.click();

        WebElement checkoutButton;
        checkoutButton = driver.findElement(By.name("checkout"));
        checkoutButton.click();

        WebElement deliveryButton;
        deliveryButton = driver.findElement(By.className("delivery-method-delivery button"));
        deliveryButton.click();

        WebElement deliverToThisAddressButton;
        deliverToThisAddressButton = driver.findElement(By.id("save-shipping-address-metapack"));
        deliverToThisAddressButton.click();

        WebElement selectAnAvailableDeliveryOptionSection;
        selectAnAvailableDeliveryOptionSection = driver.findElement(By.id("select-delivery-option"));
        Assert.assertEquals(selectAnAvailableDeliveryOptionSection.isDisplayed(), true,
                "Error: 'Select an available Delivery option' section is not displayed");

        WebElement deliveryMtshodRadiobutton;
        deliveryMtshodRadiobutton = driver.findElement(By.id("NEXTDAY"));
        deliveryMtshodRadiobutton.click();

        WebElement selectAPaymentMethodSection;
        selectAPaymentMethodSection = driver.findElement(By.id("checkout-payment"));
        Assert.assertEquals(selectAPaymentMethodSection.isDisplayed(), true,
                "Error: 'Select a payment method' section is not displayed");

        WebElement payByCardRadiobutton;
        payByCardRadiobutton = driver.findElement(By.className("l-table-cell radio-cell no-border"));
        payByCardRadiobutton.click();

        WebElement billingDetailsSection;
        billingDetailsSection = driver.findElement(By.id("checkout_form_use_delivery"));
        Assert.assertEquals(billingDetailsSection.isDisplayed(), true,
                "Error: 'Billing details' section is not displayed");

        WebElement useDeliveryAddressCheckbox;
        useDeliveryAddressCheckbox = driver.findElement(By.id("checkout_form_use_delivery"));
        useDeliveryAddressCheckbox.click();

        WebElement saveAddressButton;
        saveAddressButton = driver.findElement(By.className("button save-address address-vis"));
        saveAddressButton.click();

        WebElement addYourCardDetailsSection;
        addYourCardDetailsSection = driver.findElement(By.id("cardType"));
        Assert.assertEquals(addYourCardDetailsSection.isDisplayed(), true,
                "Error: 'Add your card details' section is not displayed");

        WebElement selectYourCardTypeDropdown;
        selectYourCardTypeDropdown = driver.findElement(By.className("selectBox selectBox-dropdown selectBox-menuShowing"));
        selectYourCardTypeDropdown.click();

        WebElement enterPaymentDetailsSection;
        enterPaymentDetailsSection = driver.findElement(By.id("paymentDetailsPanel"));
        Assert.assertEquals(enterPaymentDetailsSection.isDisplayed(), true,
                "Error: 'Enter Payment Details' section is not displayed");

        WebElement CardNumberField;
        CardNumberField = driver.findElement(By.id("cardNumber"));
        CardNumberField.sendKeys("4444333322221145");

        WebElement expiryMonthDropdown;
        expiryMonthDropdown = driver.findElement(By.id("expiryMonth"));
        expiryMonthDropdown.click();

        Select expiryMonth = new Select(expiryMonthDropdown);
        expiryMonth.selectByValue("05");

        WebElement expiryYearDropdown;
        expiryYearDropdown = driver.findElement(By.id("expiryMonth"));
        expiryYearDropdown.click();

        Select expiryYear = new Select(expiryYearDropdown);
        expiryYear.selectByValue("2018");

        WebElement cardSecurityCodeField;
        cardSecurityCodeField = driver.findElement(By.id("csc"));
        cardSecurityCodeField.sendKeys("123");

        WebElement payNowButton;
        payNowButton = driver.findElement(By.id("btnSubmit"));
        payNowButton.click();


        //127.0.0.1 app.yieldify.com cloudfront.net
    }

}
