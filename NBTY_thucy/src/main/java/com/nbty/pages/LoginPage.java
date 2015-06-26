package com.nbty.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

/**
 * Created by Siarhei Bolka on 6/25/2015.
 */

@DefaultUrl("https://hb-dev3.oracleoutsourcing.com/my-account/login.jsp?myaccount=true")
public class LoginPage extends PageObject {


    @FindBy(id = "frm_login_email")
    private WebElementFacade emailAddressField;

    @FindBy(id = "frm_login_password")
    private WebElementFacade passwordField;

    @FindBy(name = "/atg/userprofiling/ProfileFormHandler.login")
    private WebElementFacade signInButton;


    public void fillInEmail() {
        element(emailAddressField).type("mail4bsv@gmail.com");
    }

    public void fillInPassword() {
        element(passwordField).type("123456");
    }

    public void pressSignInButton() {
        element(signInButton).click();
    }
}
