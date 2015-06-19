package decorator;

import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public class StyleVisibleElement extends WebElementDecorator{

    protected StyleVisibleElement styleVisibleElement;

    public StyleVisibleElement(WebElement decoratedWebElement) {
        super(decoratedWebElement);
    }

/*    @Override
    public void sendKeys(CharSequence... keysToSend) {
        super.sendKeys(keysToSend);
    }*/

    @Override
    public boolean isDisplayed() {
        //return !styleVisibleElement.getCssValue("display").equals("none");
        return super.isDisplayed();
    }

}
