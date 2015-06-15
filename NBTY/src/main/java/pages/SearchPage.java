package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public class SearchPage {

    private WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(xpath = "//div[@id='searchResult']/div[contains(@class,'crumb') and contains(@class ,'static')]/ul/" +
            "li[not(contains(text(),'Search Results')) and not(contains(text(),'Home'))]")
    private WebElement breadCrumpOfFoundedText;

    public SearchPage(WebDriver driver, String textForSearch) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public boolean areProductsFounded()
    {
        wait.until(ExpectedConditions.visibilityOf(breadCrumpOfFoundedText));
        System.out.println(breadCrumpOfFoundedText.isDisplayed());
        return breadCrumpOfFoundedText.isDisplayed();
    }
}
