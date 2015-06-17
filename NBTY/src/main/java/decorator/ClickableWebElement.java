package decorator;

import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/17/2015.
 */
public class ClickableWebElement extends WebElementDecorator{

    protected ClickableWebElement clickableWebElement;

    public ClickableWebElement(WebElement decoratedWebElement) {
        super(decoratedWebElement);
    }

    public void clickAndLog() {
        //TODO add implementation
        super.click();
        System.out.println(clickableWebElement + " element is clicked/n");
    }
}
