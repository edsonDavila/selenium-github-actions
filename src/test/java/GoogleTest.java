import Pages.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest extends ExtentSetup{
    WebDriver driver;
    private GooglePage googlePage;
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        WebDriverManager wdm;
        wdm = WebDriverManager.chromedriver().browserVersion("122");
        wdm.setup();
        System.out.println("Ending Before Class");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();

        System.out.println("Ending driver set up");
    }

    @Test(groups = "google")
    public void test1() {
        test = extentReports.createTest("Google Search Test");
        googlePage = new GooglePage(driver,test);
        String textToSearch = "Apex Systems";
        driver.navigate().to("https://google.com");
        googlePage.typeSearchBar(textToSearch);
        String actualText = googlePage.getLinkText();
        System.out.println("Actual Text: "+  actualText);

        Assert.assertEquals(actualText,textToSearch);
        test.pass("Expected Link Message: "+ textToSearch + " Actual Link Message: "+actualText);


    }
}
