package decorator;

import org.openqa.selenium.WebElement;
import utils.localDriver.WebDriverSingleton;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public class SizeVisibleElement extends WebElementDecorator{

    protected SizeVisibleElement sizeVisibleElement;

    public SizeVisibleElement(WebElement decoratedWebElement) {
        super(decoratedWebElement);
    }

    @Override
    public boolean isDisplayed() {
/*       if ((sizeVisibleElement.getSize().getHeight() > 0) && (sizeVisibleElement.getSize().getWidth() > 0)) {
           return super.isDisplayed();
        }*/
        return super.isDisplayed();
    }
}
