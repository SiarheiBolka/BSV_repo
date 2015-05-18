package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

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

    @FindBy(linkText = "Collection")
    private WebElement buttonCollection;

    @FindBy(id = "frm_registration-rfl_postcode-lookup")
    private WebElement fieldPostcode;

    @FindBy(id = "shippingLookupButton")
    private WebElement buttonLookUpAddress;

    @FindBy(xpath = "//a[contains(text(), 'Signtech, 2, Clarendon Road, St. Helier, JERSEY JE2 3YS')]")
    private WebElement valueAddressSearchResult;

    @FindBy(xpath = "//a[contains(text(), 'Signtech, 2, Clarendon Road, St. Helier, JERSEY JE2 3YS')]")
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

    public void selectDeliveryMethod (String method)
    {
        if (method == "delivery") {
            buttonDelivery.click();
        } else if (method == "collection") {
            buttonCollection.click();
        }
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

/*    public WebElement getValueSelectedAddressSearchResult()
    {
        return valueSelectedAddressSearchResult;
    }*/

    public void submitDeliveryAddress()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Signtech, 2, Clarendon Road, St. Helier, JERSEY JE2 3YS')]")));
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

    public void selectCardType(String cardType) {
        Assert.assertEquals(dropdownSelectYourCardType.isDisplayed(), true, "Error: Card Type dropdown is not displayed");
        dropdownSelectYourCardType.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO @FindBy
        driver.findElement(By.xpath("//a[@rel='" + cardType + "']")).click();
    }

    public void setCardNumber()
    {
        cardNumber.sendKeys("4444333322221145");
    }

    public void setExpiryMonth()
    {
        dropdownExpiryMonth.sendKeys("05");
    }

    public void setExpiryYear()
    {
        dropdownExpiryYear.sendKeys("18");
    }

    public void setCardSecurityCode()
    {
        cardSecurityCode.sendKeys("123");
    }

    public void fillPaymentDetails()
    {
        driver.switchTo().frame(framePayPage);
        setCardNumber();
        setExpiryMonth();
        setExpiryYear();
        setCardSecurityCode();
        buttonPayNow.click();
    }

    public void setFieldPassword()
    {
        fieldPassword.sendKeys("password");
    }

    public void clickButtonSubmit()
    {
        buttonSubmit.click();
    }

}
