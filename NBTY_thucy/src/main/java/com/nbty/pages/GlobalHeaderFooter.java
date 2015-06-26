package com.nbty.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by Siarhei Bolka on 6/25/2015.
 */

public class GlobalHeaderFooter extends PageObject {

    @FindBy(linkText = "Logout")
    private WebElement linkLogout;

    public void isLinkLogoutPresent() {
        element(linkLogout).shouldBeVisible();
    }
}
