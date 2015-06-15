package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "frm_login_email")
    private WebElement emailAddressField;

    @FindBy(id = "frm_login_password")
    private WebElement passwordField;

    @FindBy(name = "/atg/userprofiling/ProfileFormHandler.login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    public void setEmail(String email) {
        emailAddressField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public HomePage login(String validEmail, String validPassword) {
        setEmail(validEmail);
        setPassword(validPassword);
        signInButton.click();
        return new HomePage (driver);
    }
}
