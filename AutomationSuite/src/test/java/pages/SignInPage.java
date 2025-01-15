package pages;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends testBase {

    @FindBy(xpath = ("//input[@id='email']"))
    public WebElement emailInputBox;

    @FindBy(xpath = ("//input[@id='pass' and @name='login[password]']"))
    public WebElement passwordInputBox;

    @FindBy(xpath = ("//button[@id='send2' and @type='submit' and @class='action login primary']"))
    public WebElement signInButton;

    public SignInPage() {
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check testBase setup.");
        }
        PageFactory.initElements(driver, this);
    }

}