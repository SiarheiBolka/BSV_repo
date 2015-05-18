package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class CheckoutDeliveryPaymentPage {

    private WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(linkText = "Delivery")
    private WebElement buttonDelivery;

    @FindBy(id = "frm_registration-rfl_postcode-lookup")
    private WebElement fieldPostcode;

    @FindBy(id = "shippingLookupButton")
    private WebElement buttonLookUpAddress;

    @FindBy(xpath = "//a[contains(text(), 'Signtech, 2, Clarendon Road, St. Helier, JERSEY JE2 3YS')]")
    private WebElement valueAddressSearchResult;

    @FindBy(xpath = "//li[@class='data_attr_value selectBox-selected'")
    private WebElement valueSelectedAddressSearchResult;

    @FindBy(id = "mpDeliverButtonId")
    private WebElement buttonContinueInDeliveryDetailsSection;

    @FindBy(xpath = "//label[@class='radio clearfix ']")
    private WebElement radiobuttonDeliveryOption;

    @FindBy(xpath = "//span[contains(.,' Pay by card ')]")
    private WebElement radiobuttonPayByCard;

    @FindBy(xpath = "//span[contains(.,' Pay with PayPal ')]")
    private WebElement radiobuttonPayWithPaypal;

    @FindBy(id = "checkout_form_use_delivery")
    private WebElement checkboxUseDeliveryAddress;

    @FindBy(id = "submitBillingAddress")
    private WebElement buttonContinueInBillingAddressSection;

    @FindBy(xpath = "//a[@class='selectBox selectBox-dropdown']")
    private  WebElement dropdownSelectYourCardType;

    @FindBy(xpath = "//a[@rel='Visa']")
    private  WebElement cardVisa;

    @FindBy(xpath = "//iframe[@class='checkout-iframe']")
    private  WebElement framePayPage;

    @FindBy(xpath = "//input[contains(@placeholder,'Enter your Card Number')]")
    private  WebElement cardNumber;

    @FindBy(id = "expiryMonth")
    private  WebElement dropdownExpiryMonth;

    @FindBy(id = "expiryYear")
    private  WebElement dropdownExpiryYear;

    @FindBy(id = "csc")
    private  WebElement cardSecurityCode;

    @FindBy(xpath = "//input[@value='Pay Now']")
    private  WebElement buttonPayNow;

    @FindBy(xpath = "//input[@name='acsPassword']")
    private  WebElement fieldPassword;

    @FindBy(xpath = "//input[@value='Submit']")
    private  WebElement buttonSubmit;


    public CheckoutDeliveryPaymentPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public void selectDeliveryMethod()
    {
        buttonDelivery.click();
    }

    public void setPostcode()
    {
        fieldPostcode.sendKeys("2");
    }

    public void clickButtonLookUpAddress()
    {
        buttonLookUpAddress.click();
    }

    public void SelectValueAddressSearchResult()
    {
        valueAddressSearchResult.click();
    }

    public void submitDeliveryAddress()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//a[contains(text(), 'Signtech, 2, Clarendon Road, St. Helier, JERSEY JE2 3YS')]")));
        buttonContinueInDeliveryDetailsSection.click();
    }

    public void selectDeliveryOption()
    {
        radiobuttonDeliveryOption.click();
    }

    public void selectPaymentMethod (char method)
    {
        switch (method)
        {
            case 'c':
                radiobuttonPayByCard.click();
                break;
            case 'p':
                radiobuttonPayWithPaypal.click();
                break;
            default:
                break;
        }
    }

    public void selectCheckboxUseDeliveryAddress()
    {
        checkboxUseDeliveryAddress.click();
    }

    public void submitBillingAddress()
    {
        buttonContinueInBillingAddressSection.click();
    }

    public void selectCardVisa()
    {
        new Actions(driver).moveToElement(dropdownSelectYourCardType).build().perform();
        new Actions(driver).clickAndHold(dropdownSelectYourCardType).build().perform();
        wait.until(ExpectedConditions.visibilityOf(cardVisa));
        cardVisa.click();
    }

    public void setCardNumber(String cardNum)
    {
        cardNumber.sendKeys(cardNum);
    }

    public void setExpiryMonth(String expiryMonth)
    {
        dropdownExpiryMonth.sendKeys(expiryMonth);
    }

    public void setExpiryYear(String expiryYear)
    {
        dropdownExpiryYear.sendKeys(expiryYear);
    }

    public void setCardSecurityCode(String cardSecCode)
    {
        cardSecurityCode.sendKeys(cardSecCode);
    }

    public void clickButtonPayNow()
    {
        buttonPayNow.click();
    }

    public void setFieldPassword(String password)
    {
        fieldPassword.sendKeys(password);
    }

    public void clickButtonSubmit()
    {
        buttonSubmit.click();
    }

    public OrderConfirmationPage setPaymentDetails(Map paymentDetails)
    {
        selectDeliveryMethod();
        setPostcode();
        clickButtonLookUpAddress();
        SelectValueAddressSearchResult();

        //PageFactory.initElements(driver, this);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //wait.until(ExpectedConditions.visibilityOf(valueSelectedAddressSearchResult));

        submitDeliveryAddress();
        selectDeliveryOption();
        selectPaymentMethod(((String) paymentDetails.get("paymentType")).charAt(0));
        selectCheckboxUseDeliveryAddress();
        submitBillingAddress();
        selectCardVisa();
        driver.switchTo().frame(framePayPage);
        setCardNumber((String) paymentDetails.get("cardNumber"));
        setExpiryMonth((String) paymentDetails.get("expiryMonth"));
        setExpiryYear((String) paymentDetails.get("expiryYear"));
        setCardSecurityCode((String) paymentDetails.get("cardSecurityCode"));
        clickButtonPayNow();
        setFieldPassword((String) paymentDetails.get("password"));
        clickButtonSubmit();
        return new OrderConfirmationPage(driver);
    }

}

