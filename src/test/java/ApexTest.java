import apex.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ApexTest {
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
        googlePage = new GooglePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
        System.out.println("quit Driver");
    }

    @Test(groups = "apex")
    public void apexTest1() {
        driver.manage().window().maximize();
        driver.navigate().to(Data.url);
        ApexPage apexPage = new ApexPage(driver);
        apexPage.clickOnAcceptCookiesButton();

        NavBar navBar = new NavBar(driver);
        navBar.hoverOnWhatWeDoExpandButton();
        navBar.clickOnQualityAssuranceAndTestingLink();

        QualityAssuranceAndTestingPage qualityAssuranceAndTestingPage = new QualityAssuranceAndTestingPage(driver);
        qualityAssuranceAndTestingPage.scrollToConnectWithUsLink();
        qualityAssuranceAndTestingPage.clickOnConnectWithUsLink();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Assert.assertEquals(contactUsPage.getPageName(),"Let's Connect");
        contactUsPage.typeFullName(Data.fullname);
        contactUsPage.selectContactReasonByText(Data.contactReason);
        contactUsPage.typeEmail(Data.email);
        contactUsPage.selectLocationByText(Data.location);
        contactUsPage.typeSubject(Data.messagesubject);
        contactUsPage.typeMessage(Data.message);



    }
}
