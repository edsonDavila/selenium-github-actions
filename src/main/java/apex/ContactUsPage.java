package apex;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private WebDriverWait wdw;

    @FindBy(xpath = "//h1[text() = \"Let's Connect\"]")
    private WebElement letsConnectTitle;

    @FindBy(id = "edit-full-name")
    private WebElement fullNameInput;

    @FindBy(id = "edit-contact-reason")
    private WebElement contactReasonSelect;

    @FindBy(id = "edit-email")
    private WebElement emailInput;

    @FindBy(id = "edit-area")
    private WebElement locationAreaSelect;

    @FindBy(id = "edit-subject")
    private WebElement subjectInput;

    @FindBy(id = "edit-message")
    private WebElement messageTextArea;

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void typeFullName(String fullName) {

        this.wdw.until(ExpectedConditions.visibilityOf(fullNameInput));
        fullNameInput.sendKeys(fullName);
    }

    public void selectContactReasonByText(String reasonText) {
        this.wdw.until(ExpectedConditions.visibilityOf(contactReasonSelect));

        Select select = new Select(contactReasonSelect);
        select.selectByVisibleText(reasonText);
    }

    public void selectContactReasonByValue(String reasonValue) {
        this.wdw.until(ExpectedConditions.elementToBeClickable(contactReasonSelect));

        Select select = new Select(contactReasonSelect);
        select.selectByValue(reasonValue);
    }

    public void typeEmail(String email) {

        this.wdw.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys(email);
    }

    public void selectLocationByText(String locationText) {
        this.wdw.until(ExpectedConditions.elementToBeClickable(locationAreaSelect));

        Select select = new Select(locationAreaSelect);
        select.selectByVisibleText(locationText);
    }

    public void selectLocationByValue(String locationValue) {
        this.wdw.until(ExpectedConditions.elementToBeClickable(locationAreaSelect));
        Select select = new Select(locationAreaSelect);
        select.selectByValue(locationValue);
    }

    public void typeSubject(String subject) {
        this.wdw.until(ExpectedConditions.visibilityOf(subjectInput));
        subjectInput.sendKeys(subject);
    }

    public void typeMessage(String message) {
        this.wdw.until(ExpectedConditions.visibilityOf(messageTextArea));
        messageTextArea.sendKeys(message);
    }

    public String getPageName() {
        this.wdw.until(ExpectedConditions.visibilityOf(letsConnectTitle));
        return letsConnectTitle.getText();
    }


}
