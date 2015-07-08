package pages;

import Utils.AndroidDriverSingleton;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class RegisterSecondPage {
    Wait<WebDriver> wait;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    public List<MobileElement> textFieldsOnRegistrationPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").description(\"Create my Basecamp account\")")
    public MobileElement createAccountButton;

    public RegisterSecondPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidDriverSingleton.createDriver()), this);
    }

    public void setFullName(String fullName)
    {
        textFieldsOnRegistrationPage.get(0).sendKeys(fullName);
    }

    public void setCompanyName(String companyName)
    {
        textFieldsOnRegistrationPage.get(1).sendKeys(companyName);
    }

    public void setEmail(String email)
    {
        textFieldsOnRegistrationPage.get(2).sendKeys(email);
    }

    public void setPassword(String password)
    {
        textFieldsOnRegistrationPage.get(0).sendKeys(password);
    }

    public SuccessfullRegistrationPage fillRegistrationForm (String fullName, String companyName, String email, String password)
    {
        setFullName(fullName);
        setCompanyName(companyName);
        setEmail(email);
        AndroidDriverSingleton.createDriver().swipe(20, 450, 50, 50, 400);
        setPassword(password);
        clickcreateAccountButton();
        AndroidDriverSingleton.createDriver().swipe(20, 450, 50, 50, 400);
        return new SuccessfullRegistrationPage();
    }

    public void clickcreateAccountButton ()
    {
        createAccountButton.click();
    }

}
