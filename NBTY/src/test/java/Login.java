import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/6/2015.
 */
public class Login {
    
    @Test(groups = { "login" })
    public static void loginByUser() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://hb-preprod.oracleoutsourcing.com/");

        WebElement myAccLink;
        myAccLink = driver.findElement(By.className("lnk-my-account"));
        myAccLink.click();

        WebElement email;
        email = driver.findElement(By.id("frm_login_email"));
        email.sendKeys("mail4bsv@gmail.com");

        WebElement password;
        password = driver.findElement(By.id("frm_login_password"));
        password.sendKeys("123456");

        WebElement signInButton;
        signInButton = driver.findElement(By.name("/atg/userprofiling/ProfileFormHandler.login"));
        signInButton.click();

        WebElement logout;
        logout = driver.findElement(By.linkText("Logout"));
        Assert.assertEquals(logout.isDisplayed(), true, "Error: User is not logged in");




        //127.0.0.1 app.yieldify.com cloudfront.net
    }

}
