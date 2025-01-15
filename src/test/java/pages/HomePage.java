package pages;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends testBase {

    @FindBy(xpath = ("//div[@class='panel header']/ul/li/span/button[@data-action='customer-menu-toggle']"))
    public WebElement profileDropdown;

    @FindBy(xpath = ("(//a[contains(text(),'Sign Out')])[1]"))
    public WebElement signOutButton;

    public HomePage() {
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check testBase setup.");
        }
        PageFactory.initElements(driver, this);
    }

}