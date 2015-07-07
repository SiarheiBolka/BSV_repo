import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 6/30/2015.
 */
public class RegistrationTest {

    @Test
    public void iCanRegisterNewUser() {

        URL seleniumGridUrl = null;
        String myApp = "d:/Android/platform-tools/com.basecamp.app.apk";

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.APP, myApp);

        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        AndroidDriver driver = new AndroidDriver(seleniumGridUrl, dc);
        driver.manage().timeouts().implicitlyWait(900, TimeUnit.SECONDS);

        WebElement linkElem = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").description(\"Sign up for a 60-day free trial\")");
        linkElem.click();

        WebElement buttonStart = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").description(\"Start your 60-day free trial\")");
        System.out.println("buttonStart coordinates are: " + buttonStart.getLocation() + "\n");

        driver.swipe(714, 1146, 714, 846, 300);

        buttonStart.click();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> elementsOnRegistrationPage = driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
        System.out.println("Quantity of android.view.View elements on Registration page is" + elementsOnRegistrationPage.size());

        WebElement fullNameField = elementsOnRegistrationPage.get(0);
        fullNameField.sendKeys("Mr.Tim");
        WebElement companyNameField = elementsOnRegistrationPage.get(1);
        companyNameField.sendKeys("BestCo");
        WebElement emailField = elementsOnRegistrationPage.get(2);
        emailField.clear();
        emailField.sendKeys("test_mail" + randInt(1, 10000) + "@mailinator.com");
        driver.swipe(20, 450, 50, 50, 400);
        WebElement passwordField = elementsOnRegistrationPage.get(3);
        passwordField.sendKeys("12345678fuch");

        driver.swipe(20, 450, 50, 50, 400);
        WebElement buttonCreateAcc = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").description(\"Create my Basecamp account\")");
        buttonCreateAcc.click();

        System.out.println("The End\n");

    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}

