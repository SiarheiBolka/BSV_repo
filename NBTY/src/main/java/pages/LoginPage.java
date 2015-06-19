package pages;

import decorator.SizeVisibleElement;
import decorator.StyleVisibleElement;
import decorator.WebElementComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.localDriver.WebDriverSingleton;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public class LoginPage {

    @FindBy(id = "frm_login_email")
    private WebElement emailAddressField;

    @FindBy(id = "frm_login_password")
    private WebElement passwordField;

    @FindBy(name = "/atg/userprofiling/ProfileFormHandler.login")
    private WebElement signInButton;

    public LoginPage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public void setEmail(String email) {

        //WebElement emailAddressField = new SizeVisibleElement(new StyleVisibleElement(new WebElementComponent(By.id("frm_login_email"))));

        emailAddressField.sendKeys(email);
        //return !emailAddressField2.getCssValue("display").equals("none");

        //emailAddressField2.getSize().getHeight() > 0
        //emailAddressField2.getSize().getWidth() > 0
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public HomePage login(String validEmail, String validPassword) {
        setEmail(validEmail);
        setPassword(validPassword);
        signInButton.click();
        return new HomePage();
    }
}

