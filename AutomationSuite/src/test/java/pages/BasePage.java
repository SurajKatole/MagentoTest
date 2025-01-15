package pages;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends testBase {

    @FindBy(xpath = ("//header/div/div/ul/li/a[contains(text(),'Create an Account')]"))
    public WebElement createAccountButton;

    @FindBy(xpath = ("//header/div/div/ul/li/a[contains(text(),'Sign In')]"))
    public WebElement signInButton;


    public BasePage() {
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check testBase setup.");
        }
        PageFactory.initElements(driver, this);
    }

}