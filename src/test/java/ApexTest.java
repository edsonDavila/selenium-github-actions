import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void test1(){

    }
}
