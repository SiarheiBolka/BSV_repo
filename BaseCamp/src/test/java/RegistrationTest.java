import Utils.AndroidDriverSingleton;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterFirstPage;
import pages.RegisterSecondPage;
import pages.SuccessfullRegistrationPage;

import java.util.List;

import static Utils.RandomGenerator.randInt;

/**
 * Created by Siarhei Bolka on 6/30/2015.
 */
public class RegistrationTest {

    HomePage homePage;
    RegisterFirstPage registerFirstPage;
    RegisterSecondPage registerSecondPage;
    SuccessfullRegistrationPage successfullRegistrationPage;

    @AfterTest
    public void clean()
    {
        AndroidDriverSingleton.closeAndroidDriver();
    }

    @Test
    public void iCanRegisterNewUser() {

        homePage = new HomePage();
        registerFirstPage = homePage.clickStartRegistrationLink();
        registerSecondPage = registerFirstPage.clickStartButton();
        successfullRegistrationPage = registerSecondPage.fillRegistrationForm(
                "Mr.Tim",
                "BestComp",
                "test_mail" + randInt(1, 10000) + "@mailinator.com",
                "12345678fuch");

        Assert.assertEquals(
                successfullRegistrationPage.isContinueButtonPresent(),
                true,
                "Error: new user is not registered");

    }

}

