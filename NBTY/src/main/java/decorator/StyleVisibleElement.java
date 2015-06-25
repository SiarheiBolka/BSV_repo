package decorator;

import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public class StyleVisibleElement extends WebElementDecorator{

    public StyleVisibleElement(WebElement decoratedWebElement) {
        super(decoratedWebElement);
    }

/*    @Override
    public void sendKeys(CharSequence... keysToSend) {
        super.sendKeys(keysToSend);
    }*/

    @Override
    public boolean isDisplayed() {
        if (!decoratedWebElement.getCssValue("display").equals("none")){
            return true;
        }

        return super.isDisplayed();
    }

}
