package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.localDriver.WebDriverSingleton;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei Bolka on 6/15/2015.
 */
public class SearchPage {

    Wait<WebDriver> wait;

    @FindBy(xpath = "//div[@id='searchResult']/div[contains(@class,'crumb')]//li[2]")
    WebElement theSecondBreadCrumb;

    String textForSearch;

    //TODO
    public SearchPage(String textForSearch) throws MalformedURLException {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
        this.wait = new FluentWait<WebDriver>(WebDriverSingleton.getWebDriverInstance())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        this.textForSearch = textForSearch;
    }

    public boolean areProductsFounded()    {
        wait.until(ExpectedConditions.visibilityOf(theSecondBreadCrumb));
        System.out.println(theSecondBreadCrumb.isDisplayed());
        return theSecondBreadCrumb.getText().equals(textForSearch);
    }
}
