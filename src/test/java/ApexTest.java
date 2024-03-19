import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ApexTest {
    WebDriver driver;
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

    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
        System.out.println("quit Driver");
    }

    @Test
    public void test1(){
        System.out.println("Into the testcase");

    }
}
