package pages;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends testBase {

    @FindBy(xpath = ("//input[@id='firstname']"))
    public WebElement firstNameInputBox;

    @FindBy(xpath = ("//input[(@id='lastname')]"))
    public WebElement lastNameInputBox;

    @FindBy(xpath = ("//input[(@id='email_address')]"))
    public WebElement emailInputBox;

    @FindBy(xpath = ("//input[(@id='password')]"))
    public WebElement passwordInputBox;

    @FindBy(xpath = ("//input[(@id='password-confirmation')]"))
    public WebElement confirmPasswordInputBox;

    @FindBy(xpath = ("//button[@title='Create an Account']"))
    public WebElement createAccountButton;
    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

}