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
        DELIVERY_TYPE, POST_CODE, PAYMENT_TYPE, CARD_TYPE, CARD_NUMBER, EXPIRY_MONTH, EXPIRY_YEAR, CARD_SECURITY_CODE, PASSWORD;
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

    public enum DeliveryType{
        DELIVERY("Delivery"), COLLECTION("Collection");

        String type;

        DeliveryType(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public enum CardType{
        MASTER_CARD("Master Card"),
        MASTER_CARD_DEBIT("Master Card Debit"),
        VISA("Visa"),
        VISA_DEBIT("Visa Debit"),
        MAESTRO("Maestro"),
        AMERICAN_EXPRESS("American Express");

        String type;

        CardType(String type){
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

    @FindBy(linkText = "Collection")
    private WebElement buttonCollection;

    @FindBy(id = "frm_registration-rfl_postcode-lookup")
    private WebElement fieldPostcode;

    @FindBy(id = "shippingLookupButton")
    private WebElement buttonLookUpAddress;

    @FindBy(xpath = "//a[contains(text(), 'The 1, 71 Lee Lane, Horwich, BOLTON BL6 7AU ')]")
    private WebElement valueAddressSearchResult;

    @FindBy(id = "checkout_form_town")
    private WebElement fieldTown;

    //TODO use contains - done

    @FindBy(xpath = "//li[@class='selectBox-disabled']")
    private WebElement elementPleaseSelect;

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

    @FindBy(linkText = "Select your card type")
    private  WebElement dropdownSelectYourCardType;


    @FindBy(xpath = "//a[@rel='Master Card']")
    private  WebElement cardMasterCard;

    @FindBy(xpath = "//a[@rel='Master Card Debit']")
    private  WebElement cardMasterCardDebit;

    @FindBy(xpath = "//a[@rel='Visa']")
    private  WebElement cardVisa;

    @FindBy(xpath = "//a[@rel='Visa Debit']")
    private  WebElement cardVisaDebit;

    @FindBy(xpath = "//a[@rel='Maestro']")
    private  WebElement cardMaestro;

    @FindBy(xpath = "//a[@rel='American Express']")
    private  WebElement cardAmericanExpress;


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

    public void selectDeliveryMethod (DeliveryType deliveryType)
    {
        switch (deliveryType)
        {
            case DELIVERY:
                buttonDelivery.click();
                break;
            case COLLECTION:
                buttonCollection.click();
                break;
            default:
                break;
        }
    }

/*    public void selectDeliveryMethod() {
        buttonDelivery.click();
    }*/

    public void setPostcode(String postcode)
    {
        //TODO Add input parameters - done
        fieldPostcode.sendKeys(postcode);
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

    //TODO use enum - done
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

    public void selectCardTypeMethod (CardType cardType)
    {
        new Actions(driver).moveToElement(dropdownSelectYourCardType).build().perform();
        new Actions(driver).clickAndHold(dropdownSelectYourCardType).build().perform();

        switch (cardType)
        {
            case MASTER_CARD:
                wait.until(ExpectedConditions.visibilityOf(cardMasterCard));
                cardMasterCard.click();
                break;
            case MASTER_CARD_DEBIT:
                wait.until(ExpectedConditions.visibilityOf(cardMasterCardDebit));
                cardMasterCardDebit.click();
                break;
            case VISA:
                wait.until(ExpectedConditions.visibilityOf(cardVisa));
                cardVisa.click();
                break;
            case VISA_DEBIT:
                wait.until(ExpectedConditions.visibilityOf(cardVisaDebit));
                cardVisaDebit.click();
                break;
            case MAESTRO:
                wait.until(ExpectedConditions.visibilityOf(cardVisaDebit));
                cardVisaDebit.click();
                break;
            case AMERICAN_EXPRESS:
                wait.until(ExpectedConditions.visibilityOf(cardAmericanExpress));
                cardAmericanExpress.click();
                break;
            default:
                break;
        }
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

    //TODO Add input parameters (deliveryType, deliveryDetails) - done
    public OrderConfirmationPage setPaymentDetails(HashMap<PaymentDetails, String> paymentDetails)
    {
        selectDeliveryMethod(getDeliveryType((paymentDetails.get(PaymentDetails.DELIVERY_TYPE))));
        setPostcode(paymentDetails.get(PaymentDetails.POST_CODE));
        clickButtonLookUpAddress();
        selectValueAddressSearchResult();

        //TODO use wait - done
        waitForElementIsNotEmpty(fieldPostcode, paymentDetails.get(PaymentDetails.POST_CODE));

        submitDeliveryAddress();
        selectDeliveryOption();

        //TODO first - done
        selectPaymentMethod(getPaymentType(paymentDetails.get(PaymentDetails.PAYMENT_TYPE)));

        selectCheckboxUseDeliveryAddress();
        submitBillingAddress();

        //TODO use List of elements
        selectCardTypeMethod(getCardType(paymentDetails.get(PaymentDetails.CARD_TYPE)));

        driver.switchTo().frame(framePayPage);
        setCardNumber(paymentDetails.get(PaymentDetails.CARD_NUMBER));
        setExpiryMonth(paymentDetails.get(PaymentDetails.EXPIRY_MONTH));
        setExpiryYear(paymentDetails.get(PaymentDetails.EXPIRY_YEAR));
        setCardSecurityCode(paymentDetails.get(PaymentDetails.CARD_SECURITY_CODE));

        clickButtonPayNow();
        setFieldPassword(paymentDetails.get(PaymentDetails.PASSWORD));
        clickButtonSubmit();
        return new OrderConfirmationPage(driver);
    }

    public DeliveryType getDeliveryType(String s){
        for(DeliveryType type : DeliveryType.values()){
            if(type.getType().equals(s)){
                return type;
            }
        }
        throw new RuntimeException("Error: Delivery type is not found");
    }

    public PaymentType getPaymentType(String s){
        for(PaymentType type : PaymentType.values()){
            if(type.getType().equals(s)){
                return type;
            }
        }
        throw new RuntimeException("Error: Payment type is not found");
    }

    public CardType getCardType(String s){
        for(CardType type : CardType.values()){
            if(type.getType().equals(s)){
                return type;
            }
        }
        throw new RuntimeException("Error: Card type is not found");
    }


    public void waitForElementIsNotEmpty (WebElement element, String textNotToBeDisplayed){
        long timeout = System.currentTimeMillis() + 15000;

        while(System.currentTimeMillis() < timeout ) {
            if (!element.getAttribute("value").isEmpty() && !element.getAttribute("value").equals(textNotToBeDisplayed)) {

                return;
            }
        }
        throw new RuntimeException("Element" + element +" is empty");
    }
}
