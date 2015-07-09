package pages;

import Utils.AndroidDriverSingleton;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class SuccessfullRegistrationPage {

    AppiumFieldDecorator afd = new AppiumFieldDecorator(AndroidDriverSingleton.createDriver(), 120, TimeUnit.SECONDS);

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").description(\"Continue\")")
    public WebElement continueButton;

    public SuccessfullRegistrationPage(){
        PageFactory.initElements(afd, this);
    }

    public boolean isContinueButtonPresent ()
    {
        return continueButton.isDisplayed();
    }
}
