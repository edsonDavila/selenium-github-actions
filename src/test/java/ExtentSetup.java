import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentSetup {
    public static ExtentReports extentReports;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;
    //public static ExtentTest test;
    public static ExtentTest testCase;
    public static WebDriver driver;


    @BeforeSuite(alwaysRun = true)
    public void suiteSetUp() throws IOException {
        File screenshotsFolder = Paths.get(System.getProperty("user.dir"), "test-output", "screenshots").toFile();
        if (screenshotsFolder.exists()){
            FileUtils.deleteDirectory(screenshotsFolder);
        }
        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/report.html");
        File jsonConfig = Paths.get(System.getProperty("user.dir"), "/src", "/test", "/resources", "/spark-config.json").toFile();
        sparkReporter.loadJSONConfig(jsonConfig);
        extentReports.attachReporter(sparkReporter);


    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) throws IOException {

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss-SSS");
                LocalDateTime dateTime = LocalDateTime.now();
                String path = Paths.get(System.getProperty("user.dir"), "test-output", "screenshots", dateTime.format(formatter) + ".png").toFile().getPath();
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                File toCopy = new File(path);
                String name = toCopy.getName();
                FileUtils.copyFile(screenshot, toCopy);
                test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/"+name).build());
                break;
            case ITestResult.SKIP:
                test.skip(MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.YELLOW));
                test.skip(result.getThrowable());
                break;
        }
        try {
            driver.quit();
        }catch (Exception ex){

        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        extentReports.flush();
    }
}
