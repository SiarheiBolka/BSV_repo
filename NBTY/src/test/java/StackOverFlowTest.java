import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Siarhei Bolka on 5/28/2015.
 */
public class StackOverFlowTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = WebDriverSingleton.getWebDriverInstance();
    }

    @AfterTest
    public void clean()
    {
        WebDriverSingleton.closeWebBrowser();
    }

    @Test (invocationCount = 3)
    public void testStackOverFlow() {
        WebDriver driver  = WebDriverSingleton.getWebDriverInstance();
        driver.navigate().to("http://www.stackoverflow.com");
    }
}
