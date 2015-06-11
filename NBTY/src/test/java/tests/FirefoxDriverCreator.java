package tests;

import decorator.Decorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by Siarhei Bolka on 5/29/2015.
 */
public class FirefoxDriverCreator extends WebDriverCreator{

    @Override
    public WebDriver createDriver() {
        FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
        FirefoxProfile profile = new FirefoxProfile();
        Decorator driver = new Decorator(new FirefoxDriver(binary, profile)); //decorator pattern
        return driver;
    }

}
