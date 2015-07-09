package pages;

import Utils.AndroidDriverSingleton;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class HomePage {

    AppiumFieldDecorator afd = new AppiumFieldDecorator(AndroidDriverSingleton.createDriver(), 120, TimeUnit.SECONDS);

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").description(\"Sign up for a 60-day free trial\")")
    public MobileElement startRegistrationLink;

    public HomePage(){
        PageFactory.initElements(afd, this);
    }

    public RegisterFirstPage clickStartRegistrationLink () {
        startRegistrationLink.click();
        return new RegisterFirstPage();
    }

}
