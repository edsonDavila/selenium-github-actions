package Pages.apex;
import Pages.PageManageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QualityAssuranceAndTestingPage extends PageManageActions {
    @FindBy(xpath = "(//div[contains(@class,'view-leadership')]//a[@href = '/contact-us'])[2]")
    private WebElement connectWithUsLink;

    public QualityAssuranceAndTestingPage(WebDriver driver, ExtentTest test){
        super(driver,test);
        PageFactory.initElements(driver,this);
    }

    public void scrollToConnectWithUsLink(){
        scrollToElement(connectWithUsLink, "Connect with us");
    }

    public void clickOnConnectWithUsLink(){
        waitUntilElementIsClickableAndClick(connectWithUsLink,"Connect with us");
    }


}
