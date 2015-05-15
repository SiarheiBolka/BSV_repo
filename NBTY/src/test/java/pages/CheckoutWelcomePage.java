package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class CheckoutWelcomePage {

    private WebDriver driver;
    By email = By.id("checkout_form_email");
    By buttonContinue = By.name("/atg/userprofiling/ProfileFormHandler.continue");

    public CheckoutWelcomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setEmail ()
    {
        driver.findElement(email).sendKeys("testmailbsv@mailinator.com");
    }

    public void clickButtonContinue ()
    {
        driver.findElement(buttonContinue).click();
    }


}
