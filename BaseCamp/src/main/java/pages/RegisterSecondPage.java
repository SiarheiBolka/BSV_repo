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

    AppiumFieldDecorator afd = new AppiumFieldDecorator(AndroidDriverSingleton.createDriver(), 120, TimeUnit.SECONDS);

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    public List<MobileElement> textFieldsOnRegistrationPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").description(\"Create my Basecamp account\")")
    public MobileElement createAccountButton;

    public RegisterSecondPage(){
        PageFactory.initElements(afd, this);
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
        textFieldsOnRegistrationPage.get(3).sendKeys(password);
    }

    public SuccessfullRegistrationPage fillRegistrationForm (String fullName, String companyName, String email, String password)
    {
        setFullName(fullName);
        AndroidDriverSingleton.createDriver().swipe(20, 250, 50, 50, 500);
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
        }
        setPassword(password);
        setEmail(email);
        setCompanyName(companyName);
        clickcreateAccountButton();
        return new SuccessfullRegistrationPage();
    }

    public void clickcreateAccountButton ()
    {
        createAccountButton.click();
    }

}
