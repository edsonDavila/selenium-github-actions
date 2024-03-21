package apex;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar {
    private WebDriverWait wdw;

    Actions actions;

    @FindBy(xpath = "(//a[text() = 'What We Do'])[1]")
    private WebElement whatWeDoExpandButton;
    @FindBy(xpath = "//a[text() = 'Quality Assurance']")
    private WebElement qualityAssuranceAndTestingLink;
    @FindBy(xpath = "//a[text() = 'Careers']/preceding-sibling::div")
    private WebElement careersExpandButton;
    @FindBy(xpath = "//nav[@id = 'block-apex-bootstrap-main-navigation']//a[text() = 'Search Jobs']")
    private WebElement searchJobsLink;




    public NavBar(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }

    public void hoverOnWhatWeDoExpandButton(){
        this.wdw.until(ExpectedConditions.elementToBeClickable(whatWeDoExpandButton));
        actions.moveToElement(whatWeDoExpandButton).perform();
    }

    public void clickOnQualityAssuranceAndTestingLink(){
        this.wdw.until(ExpectedConditions.elementToBeClickable(qualityAssuranceAndTestingLink));
        qualityAssuranceAndTestingLink.click();
    }

    public void clickOnCareersExpandButton(){
        this.wdw.until(ExpectedConditions.elementToBeClickable(careersExpandButton));
        careersExpandButton.click();
    }

    public void clickOnSearchJobsLink(){
        this.wdw.until(ExpectedConditions.elementToBeClickable(searchJobsLink));
        searchJobsLink.click();
    }
}
