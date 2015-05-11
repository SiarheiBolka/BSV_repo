import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.Selector;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/6/2015.
 */
public class Checkout {

    @Test(groups = { "checkout" })
    public static void loginByUser() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://hb-preprod.oracleoutsourcing.com/");

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

        WebElement email;
        email = driver.findElement(By.id("checkout_form_email"));
        email.sendKeys("testmailbsv@mailinator.com");

        WebElement continue1Button;
        continue1Button = driver.findElement(By.name("/atg/userprofiling/ProfileFormHandler.continue"));
        continue1Button.click();

        WebElement fnameField;
        fnameField = driver.findElement(By.id("checkout_form_firstname"));
        fnameField.sendKeys("fname");

        WebElement lnameField;
        lnameField = driver.findElement(By.id("checkout_form_lastname"));
        lnameField.sendKeys("lname");

        WebElement noThanksCheckbox;
        noThanksCheckbox = driver.findElement(By.id("checkout_form_no_account"));
        noThanksCheckbox.click();

        WebElement continue2Button;
        continue2Button = driver.findElement(By.name("/atg/commerce/order/purchase/CheckoutAboutYouFormHandler.moveToShipping"));
        continue2Button.click();

        WebElement deliveryButton;
        deliveryButton = driver.findElement(By.linkText("Delivery"));
        deliveryButton.click();

        WebElement postcodeField;
        postcodeField = driver.findElement(By.id("frm_registration-rfl_postcode-lookup"));
        postcodeField.sendKeys("2");

        WebElement lookUpAddressButton;
        lookUpAddressButton = driver.findElement(By.id("shippingLookupButton"));
        lookUpAddressButton.click();


        WebElement addressValue;
        addressValue = driver.findElement(By.xpath("//a[contains(text(), 'Signtech, 2, Clarendon Road, St. Helier, JERSEY JE2 3YS')]"));
        addressValue.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement saveAddressButton;
        saveAddressButton = driver.findElement(By.id("mpDeliverButtonId"));
        saveAddressButton.click();

        /*WebElement deliverToThisAddressButton;
        deliverToThisAddressButton = driver.findElement(By.id("save-shipping-address-metapack"));
        deliverToThisAddressButton.click();*/

        /*WebElement selectAnAvailableDeliveryOptionSection;
        selectAnAvailableDeliveryOptionSection = driver.findElement(By.className("fs-checkout feature-mist "));
        Assert.assertEquals(selectAnAvailableDeliveryOptionSection.isDisplayed(), true,
                "Error: 'Select an available Delivery option' section is not displayed");*/

        WebElement deliveryMethodRadiobutton;
        deliveryMethodRadiobutton = driver.findElement(By.xpath("//label[@for='STANDARD']"));
        //Assert.assertEquals(deliveryMethodRadiobutton.isDisplayed(), true, "delivery Method Radiobutton can't be found");
        deliveryMethodRadiobutton.click();

/*        WebElement selectAPaymentMethodSection;
        selectAPaymentMethodSection = driver.findElement(By.id("checkout-payment"));
        Assert.assertEquals(selectAPaymentMethodSection.isDisplayed(), true,
                "Error: 'Select a payment method' section is not displayed");*/

        WebElement payByCardRadiobutton;
        payByCardRadiobutton = driver.findElement(By.className("radio-cell"));
        payByCardRadiobutton.click();

        WebElement billingDetailsSection;
        billingDetailsSection = driver.findElement(By.id("checkout_form_use_delivery"));
        Assert.assertEquals(billingDetailsSection.isDisplayed(), true,
                "Error: 'Billing details' section is not displayed");

        WebElement useDeliveryAddressCheckbox;
        useDeliveryAddressCheckbox = driver.findElement(By.id("checkout_form_use_delivery"));
        useDeliveryAddressCheckbox.click();

        WebElement saveAddressButton2;
        saveAddressButton2 = driver.findElement(By.id("submitBillingAddress"));
        saveAddressButton2.click();

/*        WebElement addYourCardDetailsSection;
        addYourCardDetailsSection = driver.findElement(By.id("cardType"));
        Assert.assertEquals(addYourCardDetailsSection.isDisplayed(), true,
                "Error: 'Add your card details' section is not displayed");*/

        WebElement creditCardSelector;
        creditCardSelector = driver.findElement(By.xpath("//a[@class='selectBox selectBox-dropdown']"));
        creditCardSelector.click();
        creditCardSelector.click();

        WebElement creditCardTypeVisa;
        creditCardTypeVisa = driver.findElement(By.xpath("//a[@rel='Visa']"));
        creditCardTypeVisa.click();

        /*WebElement fnameField;
        fnameField = driver.findElement(By.id("checkout_form_firstname"));
        fnameField.sendKeys("fname");*/

        WebElement CardNumberField;
        CardNumberField = driver.findElement(By.xpath("//*[contains(text(), 'Enter your Card Number')]"));
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
    }


}
