import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Siarhei Bolka on 5/6/2015.
 */
public class Login {
    @Test(groups = { "login" })
    public static void loginByUser() {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://hb-preprod.oracleoutsourcing.com/");

        Assert.assertTrue(true);
    }

}
