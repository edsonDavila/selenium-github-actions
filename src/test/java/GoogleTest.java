import apex.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
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
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();

        System.out.println("Ending driver set up");
        googlePage = new GooglePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
        System.out.println("quit Driver");
    }

    @Test(groups = "google")
    public void test1() {
        String textToSearch = "Apex Systems";
        driver.navigate().to("https://google.com");
        googlePage.typeSearchBar(textToSearch);
        String actualText = googlePage.getLinkText();
        System.out.println("Actual Text: "+  actualText);

        Assert.assertEquals(actualText,textToSearch);


    }
}
