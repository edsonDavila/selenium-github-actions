package Pages.apex;
import Pages.PageManageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar extends PageManageActions {

    @FindBy(xpath = "(//a[text() = 'What We Do'])[1]")
    private WebElement whatWeDoExpandButton;
    @FindBy(xpath = "//a[text() = 'Quality Assurance']")
    private WebElement qualityAssuranceAndTestingLink;
    @FindBy(xpath = "//a[text() = 'Careers']/preceding-sibling::div")
    private WebElement careersExpandButton;
    @FindBy(xpath = "//nav[@id = 'block-apex-bootstrap-main-navigation']//a[text() = 'Search Jobs']")
    private WebElement searchJobsLink;




    public NavBar(WebDriver driver, ExtentTest test){
        super(driver,test);
        PageFactory.initElements(driver,this);
    }

    public void hoverOnWhatWeDoExpandButton(){
        hoverElement(whatWeDoExpandButton, "What We Do");
    }

    public void clickOnQualityAssuranceAndTestingLink(){
        waitUntilElementIsClickableAndClick(qualityAssuranceAndTestingLink,"Quality");
    }

    public void clickOnCareersExpandButton(){
        waitUntilElementIsClickableAndClick(careersExpandButton,"Careers");
    }

    public void clickOnSearchJobsLink(){
        waitUntilElementIsClickableAndClick(searchJobsLink,"Search Jobs");
    }
}
