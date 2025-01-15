package stepDefinition;

import java.io.IOException;

import base.testBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import pages.*;



public class SignUpAndSignIn extends testBase {

    static BasePage basePage = new BasePage();
    static HomePage homePage = new HomePage();
    static SignUpPage signUpPage = new SignUpPage();
    static SignInPage signInPage = new SignInPage();

    @When("User chooses create a new account option")
    public static void clickCreateAnAccount() {
        basePage.createAccountButton.click();
        System.out.println("Create a New Account Clicked, navigating to signup...");
    }

    @Then("User enters First Name as {string} and Last Name as {string}")
    public static void enterFirstAndLastName(String firstName, String lastName) {

        signUpPage.firstNameInputBox.sendKeys(firstName);
        System.out.println("First name entered..");

        signUpPage.lastNameInputBox.sendKeys(lastName);
        System.out.println("Last name entered..");
    }

    @Then("User enters Email as {string} and Password as {string} and confirm password as {string} then clicks create account button")
    public static void enterEmailPasswordAndClickCreateAccount(String email, String password, String confirmPassword) {

        signUpPage.emailInputBox.sendKeys(email);
        System.out.println("Email entered...");

        signUpPage.passwordInputBox.sendKeys(password);
        System.out.println("Password entered...");

        signUpPage.confirmPasswordInputBox.sendKeys(confirmPassword);
        System.out.println("Confirm Password entered...");

        signUpPage.createAccountButton.click();
        System.out.println("Create Account Button clicked...");
    }

    @Then("User verifies if Signed Up Successfully")
    public static void verifyAccountPage() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("My Account"), "User Sign up failed...");

    }

    @Then("User verifies for failed Sign Up")
    public static void verifyFailedSignUp() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertFalse(driver.getTitle().contains("My Account"), "User Sign up passed for invalid inputs...");

    }




    @Then("User signs out of the application")
    public static void signOutFromApplication() throws InterruptedException {
        Thread.sleep(2000);
        homePage.profileDropdown.click();
        System.out.println("Profile Dropdown clicked...");

        homePage.signOutButton.click();
        System.out.println("Sign Out Button clicked...");

    }



}
