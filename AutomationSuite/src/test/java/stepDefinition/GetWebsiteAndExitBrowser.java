package stepDefinition;

import base.testBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;

import java.io.IOException;


public class GetWebsiteAndExitBrowser extends testBase {

    @Given("User accesses the site url in browser")
    public static void getSiteUrlInBrowser() throws InterruptedException, IOException {
        initialization();
        System.out.println("------ Site Page Loaded Successfully ------");
    }

    @Given("User navigates the site url in browser")
    public static void getSiteUrl() throws InterruptedException, IOException {
        driver.navigate().to(prop.getProperty("site"));
        System.out.println("------ Site Page Loaded Successfully ------");
    }

    @Given("User closes the browser")
    public static void exitBrowser() throws InterruptedException, IOException {
        driver.quit();
    }

}
