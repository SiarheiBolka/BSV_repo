package decorator;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public abstract class WebElementDecorator implements WebElement {

    protected WebElement decoratedWebElement;

    public WebElementDecorator(WebElement decoratedWebElement) {
        this.decoratedWebElement = decoratedWebElement;
    }


    public void click() {

    }

    public void submit() {

    }

    public void sendKeys(CharSequence... keysToSend) {
        decoratedWebElement.sendKeys(keysToSend);
    }

    public void clear() {

    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String name) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public String getText() {
        return null;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return decoratedWebElement.isDisplayed();
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return decoratedWebElement.getSize();
    }

    public String getCssValue(String propertyName) {
        return decoratedWebElement.getCssValue(propertyName);
    }
}
