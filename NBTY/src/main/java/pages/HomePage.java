package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.localDriver.WebDriverSingleton;

import java.net.MalformedURLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class HomePage {

    Wait<WebDriver> wait;

    @FindBy(xpath = "//li[contains(@class, 'main-nav-item')]")
    List<WebElement> categoryList;

    @FindBy(xpath = "//li[contains(@class, 'main-nav-item')]")
    List<WebElement> subcategoryList;

    @FindBy(className = "lnk-my-account")
    private WebElement myAccountLink;

    @FindBy (linkText = "Logout")
    private WebElement logoutLink;

    @FindBy (id = "sitesearch")
    private WebElement searchField;

    @FindBy(className = "orangeSubmit")
    private  WebElement goButton;

    public HomePage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
        this.wait = new FluentWait<WebDriver>(WebDriverSingleton.getWebDriverInstance())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public LandingPage openSubcategoryPage(String categoryNmae, String subcategoryName) {
        expandMenuForCategory(categoryNmae);
        clickSubcategory(subcategoryName);
        return new LandingPage();
    }

    public LoginPage openLoginPage () {
        myAccountLink.click();
        return new LoginPage();
    }

    public boolean isUserLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        System.out.println(logoutLink.isDisplayed());
        return logoutLink.isDisplayed();
    }

    public SearchPage search(String textForSearch) throws MalformedURLException {
        searchField.sendKeys(textForSearch);
        goButton.click();
        return new SearchPage(textForSearch);
    }

    public void expandMenuForCategory(String categoryName){
        for(WebElement element : categoryList){
            if(element.getText().equals(categoryName)){
                new Actions(WebDriverSingleton.getWebDriverInstance()).moveToElement(element).build().perform();
                //element.click();
                return;
            }
        }
        throw new RuntimeException("Category '"+ categoryName +"' is NOT found.");
    }

    public void clickSubcategory(String subcategoryName){
        for(WebElement element : subcategoryList){
            if(element.getText().equals(subcategoryName)){
                new Actions(WebDriverSingleton.getWebDriverInstance()).moveToElement(element).build().perform();
                element.click();
                return;
            }
        }
        throw new RuntimeException("Subcategory '"+ subcategoryName +"' is NOT found.");
    }

}
