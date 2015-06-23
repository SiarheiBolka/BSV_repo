package decorator;

import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public class StyleVisibleElement extends WebElementDecorator{

    public StyleVisibleElement(WebElement decoratedWebElement) {
        super(decoratedWebElement);
    }

    @Override
    public boolean isDisplayed() {
        if (super.isDisplayed()){
            System.out.println("StyleVisibleElement.isDisplayed");
            return !decoratedWebElement.getCssValue("display").equals("none");
        }
        return false;
    }

}
