package pages;

import Utils.AndroidDriverSingleton;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class SuccessfullRegistrationPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").description(\"Continue\")")
    public WebElement continueButton;

    public SuccessfullRegistrationPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidDriverSingleton.createDriver()), this);
    }

    public boolean isContinueButtonPresent ()
    {
        return continueButton.isDisplayed();
    }
}
