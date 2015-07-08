package pages;

import Utils.AndroidDriverSingleton;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class RegisterFirstPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").description(\"Start your 60-day free trial\")")
    public MobileElement startButton;

    public RegisterFirstPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidDriverSingleton.createDriver()), this);
    }

    public RegisterSecondPage clickStartButton ()
    {
        AndroidDriverSingleton.createDriver().swipe(714, 1146, 714, 846, 300);
        startButton.click();
        return new RegisterSecondPage();
    }
}
