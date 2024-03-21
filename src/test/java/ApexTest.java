import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ApexTest {
    WebDriver driver;
    private GooglePage googlePage;
    @BeforeClass
    public void setUp(){
        WebDriverManager wdm;
        wdm = WebDriverManager.chromedriver().browserVersion("122");
        wdm.setup();
        System.out.println("Ending Before Class");
    }

    @BeforeMethod
    public void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        System.out.println("Ending driver set up");
        googlePage = new GooglePage(driver);
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
        System.out.println("quit Driver");
    }

    @Test
    public void test1() throws InterruptedException {
        String textToSeach = "Apex Systems";
        driver.navigate().to("https://google.com");
        googlePage.typeSearchBar(textToSeach);
        String actualText = googlePage.getLinkText();
        System.out.println("Actual Text: "+  actualText);

        Assert.assertEquals(actualText,textToSeach);


    }
}
