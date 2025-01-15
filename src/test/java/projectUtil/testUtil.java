package projectUtil;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.testBase;


public class testUtil extends testBase {
    public static long PAGE_LOAD_TIMEOUT = 120;
    public static long IMPLICIT_WAIT = 20;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/test-output/Failed_Tests/" + dtf.format(now) + ".png"));
    }









    ///////
}
