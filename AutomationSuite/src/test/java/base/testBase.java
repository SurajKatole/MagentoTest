package base;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;
import projectUtil.CustomAssertion;
import projectUtil.WebEventListener;
import projectUtil.testUtil;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class testBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static SoftAssert softAssert = new SoftAssert();
    public static CustomAssertion customAssertion;

    public testBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                    + "/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initProperties() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                + "/config/config.properties");
        prop.load(ip);
    }


    public static void initialization() throws IOException {
        initProperties();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        customAssertion = new CustomAssertion(e_driver);

        File directoryLogs = new File(System.getProperty("user.dir") + "/test-output/Logs");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        File fileLog = new File(directoryLogs, dtf.format(now)+".txt");
        fileLog.createNewFile();

        System.setOut(new PrintStream(new FileOutputStream(fileLog)));

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("site"));


    }

}