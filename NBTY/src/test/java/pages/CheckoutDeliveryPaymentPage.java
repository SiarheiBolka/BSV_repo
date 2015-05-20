package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class CheckoutDeliveryPaymentPage {

    public enum PaymentDetails{
        PAYMENT_TYPE, CARD_NUMBER, EXPIRY_MONTH, EXPIRY_YEAR, CARD_SECURITY_CODE, PASSWORD;
    }

    public enum PaymentType{
        CARD("card"), PAYPAL("paypal");

        String type;

        PaymentType(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(linkText = "Delivery")
    private WebElement buttonDelivery;

    @FindBy(id = "frm_registration-rfl_postcode-lookup")
    private WebElement fieldPostcode;

    @FindBy(id = "shippingLookupButton")
    private WebElement buttonLookUpAddress;

    @FindBy(xpath = "//a[contains(text(), 'The 1, 71 Lee Lane, Horwich, BOLTON BL6 7AU ')]")
    private WebElement valueAddressSearchResult;

    @FindBy(id = "checkout_form_town")
    private WebElement fieldTown;


    //TODO use contains - done
    //@FindBy(xpath = "//li[@class='data_attr_value selectBox-selected'")
/*    @FindBy(xpath = "//li[contains(@class,'selectBox-selected')]")
    private WebElement valueSelectedAddressSearchResult;*/

    @FindBy(xpath = "//li[@class='selectBox-disabled']")
    private WebElement elementPleaseSelect;

    @FindBy(id = "mpDeliverButtonId")
    private WebElement buttonContinueInDeliveryDetailsSection;

    @FindBy(xpath = "//label[@class='radio clearfix ']")
    private WebElement radiobuttonDeliveryOption;

/*    @FindBy(xpath = "//span[contains(@class,'l-table-cell card-name-cell no-border')]")
    List<WebElement> radiobuttonPayBy;*/


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

    @FindBy(id = "EXPIRY_MONTH")
    private  WebElement dropdownExpiryMonth;

    @FindBy(id = "EXPIRY_YEAR")
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
        //TODO Add input parameters
        fieldPostcode.sendKeys("1");
    }

    public void clickButtonLookUpAddress()
    {
        buttonLookUpAddress.click();
    }

    public void selectValueAddressSearchResult()
    {
        valueAddressSearchResult.click();
    }

    public void submitDeliveryAddress()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//a[contains(text(), 'The 1, 71 Lee Lane, Horwich, BOLTON BL6 7AU ')]")));

        buttonContinueInDeliveryDetailsSection.click();
    }

    public void selectDeliveryOption()
    {
        radiobuttonDeliveryOption.click();
    }



    //TODO use enum
    public void selectPaymentMethod (PaymentType paymentType)
    {
        switch (paymentType)
        {
            case CARD:
                radiobuttonPayByCard.click();
                break;
            case PAYPAL:
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

    //TODO Add input parameters (delivery type, delivery details)
    public OrderConfirmationPage setPaymentDetails(HashMap<PaymentDetails, String> paymentDetails)
    {
        selectDeliveryMethod();
        setPostcode();
        clickButtonLookUpAddress();
        selectValueAddressSearchResult();

        //System.out.println("Postcode field value is: " + fieldPostcode.getCssValue("Value"));
        //((JavascriptExecutor) driver).executeScript("alert('hello world');");

        //TODO use wait
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.visibilityOf(elementPleaseSelect));

        submitDeliveryAddress();
        selectDeliveryOption();

        //TODO first
        selectPaymentMethod(PaymentType.CARD);

        selectCheckboxUseDeliveryAddress();
        submitBillingAddress();

        //TODO use List of elements
        selectCardVisa();

        driver.switchTo().frame(framePayPage);
        setCardNumber(paymentDetails.get("CARD_NUMBER"));
        setExpiryMonth(paymentDetails.get("EXPIRY_MONTH"));
        setExpiryYear(paymentDetails.get("EXPIRY_YEAR"));
        setCardSecurityCode(paymentDetails.get("CARD_SECURITY_CODE"));

        clickButtonPayNow();
        setFieldPassword(paymentDetails.get("PASSWORD"));
        clickButtonSubmit();
        return new OrderConfirmationPage(driver);
    }

}

