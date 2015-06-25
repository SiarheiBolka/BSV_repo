package decorator;

import org.openqa.selenium.*;
import utils.localDriver.WebDriverSingleton;

import java.util.List;


/**
 * Created by Siarhei Bolka on 6/19/2015.
 */
public class WebElementComponent implements WebElement {

    WebElement element;

    public WebElementComponent(By locator) {
        try {
            this.element = WebDriverSingleton.getWebDriverInstance().findElement(locator);
        } catch (NoSuchElementException e) {
            //e.printStackTrace();

        }

    }

    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        System.out.println("WebElementComponent.isDisplayed");
        if (element == null) {
            return false;
        }
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }
}
