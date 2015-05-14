import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/6/2015.
 */

@Test(groups = { "checkout" })
public class Checkout {

    WebDriver driver;

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    public void checkout() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        driver.get("http://hb-preprod.oracleoutsourcing.com/");

        WebElement categoryPersonalCare;
        categoryPersonalCare = driver.findElement(By.linkText("Personal Care"));
        new Actions(driver).moveToElement(categoryPersonalCare).build().perform();

        Assert.assertEquals(categoryPersonalCare.isDisplayed(), true,
                "Error: Category 'Personal Care' is not displayed in Flyout menu");

        WebElement categoryBathing;
        categoryBathing = driver.findElement(By.linkText("Bathing"));
        wait.until(ExpectedConditions.visibilityOf(categoryBathing));
        Assert.assertEquals(categoryBathing.isDisplayed(), true,
                "Error: category 'Bathing' is not displayed");
        categoryBathing.click();

        WebElement product;
        product = driver.findElement(By.id("60083074"));
        Assert.assertEquals(product.isDisplayed(), true,
                "Error: Product '60083074' is not displayed");
        product.click();

        WebElement addToBasketButton;
        addToBasketButton = driver.findElement(By.id("cartbtn"));
        Assert.assertEquals(addToBasketButton.isDisplayed(), true,
                "Error: 'Add To Basket' button is not displayed");
        addToBasketButton.click();

        WebElement viewBasketLink;
        viewBasketLink = driver.findElement(By.linkText("View basket"));
        Assert.assertEquals(viewBasketLink.isDisplayed(), true,
                "Error: Basket is not opened");
        viewBasketLink.click();

        WebElement checkoutButton;
        checkoutButton = driver.findElement(By.name("checkout"));
        Assert.assertEquals(checkoutButton.isDisplayed(), true,
                "Error: 'Checkout' button is not displayed");
        checkoutButton.click();

        WebElement email;
        email = driver.findElement(By.id("checkout_form_email"));
        email.sendKeys("testmailbsv@mailinator.com");

        WebElement continue1Button;
        continue1Button = driver.findElement(By.name("/atg/userprofiling/ProfileFormHandler.continue"));
        Assert.assertEquals(continue1Button.isDisplayed(), true,
                "Error: 'Continue' button is not displayed");
        continue1Button.click();

        WebElement fnameField;
        fnameField = driver.findElement(By.id("checkout_form_firstname"));
        Assert.assertEquals(fnameField.isDisplayed(), true,
                "Error: 'First name' field is not displayed");
        fnameField.sendKeys("fname");

        WebElement lnameField;
        lnameField = driver.findElement(By.id("checkout_form_lastname"));
        Assert.assertEquals(lnameField.isDisplayed(), true,
                "Error: 'Last name' field is not displayed");
        lnameField.sendKeys("lname");

        WebElement noThanksCheckbox;
        noThanksCheckbox = driver.findElement(By.id("checkout_form_no_account"));
        Assert.assertEquals(noThanksCheckbox.isDisplayed(), true,
                "Error: 'No thanks' checkbox is not displayed");
        noThanksCheckbox.click();

        WebElement continue2Button;
        continue2Button = driver.findElement(By.name("/atg/commerce/order/purchase/CheckoutAboutYouFormHandler.moveToShipping"));
        Assert.assertEquals(continue2Button.isDisplayed(), true,
                "Error: 'Continue' button is not displayed");
        continue2Button.click();

        WebElement deliveryButton;
        deliveryButton = driver.findElement(By.linkText("Delivery"));
        Assert.assertEquals(deliveryButton.isDisplayed(), true,
                "Error: 'Delivery' button is not displayed");
        deliveryButton.click();

        WebElement postcodeField;
        postcodeField = driver.findElement(By.id("frm_registration-rfl_postcode-lookup"));
        postcodeField.sendKeys("2");

        WebElement lookUpAddressButton;
        lookUpAddressButton = driver.findElement(By.id("shippingLookupButton"));
        Assert.assertEquals(lookUpAddressButton.isDisplayed(), true,
                "Error: 'Look Up Address' button is not displayed");
        lookUpAddressButton.click();


        WebElement addressValue;
        addressValue = driver.findElement(By.xpath("//a[contains(text(), 'Signtech, 2, Clarendon Road, St. Helier, JERSEY JE2 3YS')]"));
        Assert.assertEquals(addressValue.isDisplayed(), true,
                "Error: Shipping address value is not displayed");
        addressValue.click();

        WebElement addressValueAfterSelection;
        addressValueAfterSelection = driver.findElement(By.xpath("//li[contains(@class,'data_attr_value selectBox-selected')]"));
        wait.until(ExpectedConditions.visibilityOf(addressValueAfterSelection));

        WebElement saveAddressButton;
        saveAddressButton = driver.findElement(By.id("mpDeliverButtonId"));
        Assert.assertEquals(saveAddressButton.isDisplayed(), true,
                "Error: 'Save Address' button is not displayed");
        saveAddressButton.click();

        WebElement selectAnAvailableDeliveryOptionSection;
        selectAnAvailableDeliveryOptionSection = driver.findElement(By.xpath(
                "//label[@class='radio clearfix ']"));
        Assert.assertEquals(selectAnAvailableDeliveryOptionSection.isDisplayed(), true,
                "Error: 'Select an available Delivery option' section is not displayed");

        WebElement deliveryMethodRadiobutton;
        deliveryMethodRadiobutton = driver.findElement(By.xpath("//label[@for='STANDARD']"));
        Assert.assertEquals(deliveryMethodRadiobutton.isDisplayed(), true,
                "Error: delivery Method Radiobutton can't be found");
        deliveryMethodRadiobutton.click();

        WebElement selectAPaymentMethodSection;
        selectAPaymentMethodSection = driver.findElement(By.id("checkout-payment"));
        Assert.assertEquals(selectAPaymentMethodSection.isDisplayed(), true,
                "Error: 'Select a payment method' section is not displayed");

        WebElement payByCardRadiobutton;
        payByCardRadiobutton = driver.findElement(By.className("radio-cell"));
        Assert.assertEquals(payByCardRadiobutton.isDisplayed(), true,
                "Error: 'Pay by Card' radiobutton is not displayed");
        payByCardRadiobutton.click();

        WebElement billingDetailsSection;
        billingDetailsSection = driver.findElement(By.id("checkout_form_use_delivery"));
        Assert.assertEquals(billingDetailsSection.isDisplayed(), true,
                "Error: 'Billing details' section is not displayed");

        WebElement useDeliveryAddressCheckbox;
        useDeliveryAddressCheckbox = driver.findElement(By.id("checkout_form_use_delivery"));
        Assert.assertEquals(useDeliveryAddressCheckbox.isDisplayed(), true,
                "Error: 'Use Delivery Address' checkbox is not displayed");
        useDeliveryAddressCheckbox.click();

        WebElement saveAddressButton2;
        saveAddressButton2 = driver.findElement(By.id("submitBillingAddress"));
        saveAddressButton2.click();

        WebElement addYourCardDetailsSection;
        addYourCardDetailsSection = driver.findElement(By.xpath("//fieldset[@class='fs-checkout fs-checkout-card-types feature-mist']"));
        Assert.assertEquals(addYourCardDetailsSection.isDisplayed(), true,
                "Error: 'Add your card details' section is not displayed");

        WebElement creditCardSelector;
        creditCardSelector = driver.findElement(By.xpath("//span[@class='selectBox-label']"));
        Assert.assertEquals(creditCardSelector.isDisplayed(), true,
                "Error: Card Type dropdown is not displayed");
        creditCardSelector.click();

        WebElement creditCardTypeVisa;
        creditCardTypeVisa = driver.findElement(By.xpath("//a[@rel='Visa']"));
        wait.until(ExpectedConditions.visibilityOf(creditCardTypeVisa));
        Assert.assertEquals(creditCardTypeVisa.isDisplayed(), true,
                "Error: Visa Credit Card is not displayed");
        creditCardTypeVisa.click();

        WebElement payPageFrame;
        payPageFrame = driver.findElement(By.xpath("//iframe[@class='checkout-iframe']"));
        wait.until(ExpectedConditions.visibilityOf(payPageFrame));
        Assert.assertEquals(payPageFrame.isDisplayed(), true,
                "Error: TLG frame is not displayed");
        driver.switchTo().frame(payPageFrame);

        WebElement CardNumberField;
        CardNumberField = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter your Card Number')]"));
        Assert.assertEquals(CardNumberField.isDisplayed(), true,
                "Error: 'Card Number' field is not displayed");
        CardNumberField.sendKeys("4444333322221145");

        WebElement expiryMonthDropdown;
        expiryMonthDropdown = driver.findElement(By.id("expiryMonth"));
        Assert.assertEquals(expiryMonthDropdown.isDisplayed(), true,
                "Error: 'Expiry Month' dropdown is not displayed");
        expiryMonthDropdown.sendKeys("05");

        WebElement expiryYearDropdown;
        expiryYearDropdown = driver.findElement(By.id("expiryYear"));
        Assert.assertEquals(expiryYearDropdown.isDisplayed(), true,
                "Error: 'Expiry Year' dropdown is not displayed");
        expiryYearDropdown.sendKeys("18");

        WebElement cardSecurityCodeField;
        cardSecurityCodeField = driver.findElement(By.id("csc"));
        Assert.assertEquals(cardSecurityCodeField.isDisplayed(), true,
                "Error: 'Card Security Code' field is not displayed");
        cardSecurityCodeField.sendKeys("123");

        WebElement payNowButton;
        payNowButton = driver.findElement(By.id("btnSubmit"));
        Assert.assertEquals(payNowButton.isDisplayed(), true,
                "Error: 'Pay Now' button in TLG frame is not displayed");
        payNowButton.click();

        WebElement passwordConfirmField;
        passwordConfirmField = driver.findElement(By.xpath("//input[@name='acsPassword']"));
        Assert.assertEquals(passwordConfirmField.isDisplayed(), true,
                "Error: 'Password' field in TLG frame is not displayed");
        passwordConfirmField.sendKeys("password");

        WebElement submitButton;
        submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        Assert.assertEquals(submitButton.isDisplayed(), true,
                "Error: 'Submit' button in TLG frame is not displayed");
        submitButton.click();

        WebElement orderConfirmationPage;
        orderConfirmationPage = driver.findElement(By.xpath("//span[contains(.,' Your order has been received. ')]"));
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationPage));
        Assert.assertEquals(orderConfirmationPage.isDisplayed(), true,
                "Error: 'Order confirmation' page is not opened");

        driver.quit();
    }


}
