package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 5/14/2015.
 */
public class HomePage {

    private WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(linkText = "Personal Care")
    private WebElement categoryPersonalCare;

    @FindBy(xpath = "//li[contains(@class, 'main-nav-item')]")
    List<WebElement> categoryList;

    @FindBy(xpath = "//a[@href=\"/shop/personal-care/bathing/\"]")
    private WebElement subcategoryBathing;

    @FindBy(className = "lnk-my-account")
    private WebElement myAccountLink;

    @FindBy (linkText = "Logout")
    private WebElement logoutLink;

    @FindBy (id = "sitesearch")
    private WebElement searchField;

    @FindBy(className = "orangeSubmit")
    private  WebElement goButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public void openCategoryPersonalCare() {
        categoryPersonalCare.click();
    }

    public LandingPage openSubcategoryBathing() {
        new Actions(driver).moveToElement(categoryPersonalCare).build().perform();
        new Actions(driver).moveToElement(subcategoryBathing).build().perform();
        new Actions(driver).click(subcategoryBathing).build().perform();
        return new LandingPage(driver);
    }

    public LoginPage openLoginPage () {
        myAccountLink.click();
        return new LoginPage(driver);
    }

    public boolean isUserLoggedIn()
    {
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        System.out.println(logoutLink.isDisplayed());
        return logoutLink.isDisplayed();
    }

    public SearchPage findProduct (String textForSearch) {
        searchField.sendKeys(textForSearch);
        goButton.click();
        return new SearchPage(driver, textForSearch);
    }

    public void openCategory(String categoryName){
        for(WebElement element : categoryList){
            if(element.getText().equals(categoryName)){
                element.click();
                return;
            }
        }
        throw new RuntimeException("Category '"+ categoryName +"' is NOT found.");
    }

}
