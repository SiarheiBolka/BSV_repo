package pages;

import Utils.AndroidDriverSingleton;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class RegisterFirstPage {

    AppiumFieldDecorator afd = new AppiumFieldDecorator(AndroidDriverSingleton.createDriver(), 120, TimeUnit.SECONDS);

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").description(\"Start your 60-day free trial\")")
    public MobileElement startButton;

    public RegisterFirstPage(){
        PageFactory.initElements(afd, this);
    }

    public RegisterSecondPage clickStartButton ()
    {
        if (startButton.isDisplayed()) {
            AndroidDriverSingleton.createDriver().swipe(714, 1146, 714, 846, 1000);
            startButton.click();
        } else {
            System.out.println("Erorr: startButton on RegisterFirstPage is not displayed");
        }

        return new RegisterSecondPage();
    }
}
