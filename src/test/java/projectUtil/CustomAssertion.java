package projectUtil;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CustomAssertion extends SoftAssert {
    private WebDriver driver;
    public CustomAssertion(WebDriver driver) {
        this.driver=driver;
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand,
                                AssertionError ex)
    {
        System.out.println("Assertion Error: " + ex);
        try {
            testUtil.takeScreenshotAtEndOfTest();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            Assert.fail();
        }
    }
}
