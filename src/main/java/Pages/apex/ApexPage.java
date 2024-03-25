package Pages.apex;

import Pages.PageManageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApexPage extends PageManageActions {
    @FindBy(xpath = "//button[@data-target = '#navbarSupportedContent']")
    private WebElement navBarButton;
    @FindBy(xpath = "(//a[text() = 'Search'])[1]")
    private WebElement searchButton;
    @FindBy(id = "edit-sq")
    private WebElement searchInput;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookiesAlert;

    public ApexPage(WebDriver driver, ExtentTest test){
        super(driver,test);
        PageFactory.initElements(driver,this);
    }

    public void clickOnNavBarMenuButton(){
        waitUntilElementIsClickableAndClick(navBarButton,"NavBar button");
    }

    public void clickOnAcceptCookiesButton(){
        waitUntilElementIsClickableAndClick(cookiesAlert,"Accept Cookies");
    }
}
