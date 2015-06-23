package decorator;

import org.openqa.selenium.WebElement;
import utils.localDriver.WebDriverSingleton;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public class SizeVisibleElement extends WebElementDecorator{

    public SizeVisibleElement(WebElement decoratedWebElement) {
        super(decoratedWebElement);
    }

    @Override
    public boolean isDisplayed() {
/*       if ((decoratedWebElement.getSize().getHeight() > 0) && (decoratedWebElement.getSize().getWidth() > 0)) {
           return super.isDisplayed();
        }*/
        return super.isDisplayed();
    }
}
