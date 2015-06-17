package decorator;

import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public class WritableWebElement extends WebElementDecorator{

    public WritableWebElement(WebElement decoratedWebElement) {
        super(decoratedWebElement);
    }

    public void typeText() {
        //TODO add implementation
    }
}
