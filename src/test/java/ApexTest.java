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
    }

    @BeforeMethod
    public void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void test1(){

    }
}
