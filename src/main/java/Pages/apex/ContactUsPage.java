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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends PageManageActions {

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


    public ContactUsPage(WebDriver driver, ExtentTest test){
        super(driver,test);
        PageFactory.initElements(driver,this);
    }

    public void typeFullName(String fullName) {
        typeIntoElement(fullNameInput,"Full Name", fullName);
    }

    public void selectContactReasonByText(String reasonText) {
        selectOptionByText(contactReasonSelect, "Contact Reason", reasonText);
    }

    public void selectContactReasonByValue(String reasonValue) {
        selectOptionByValue(contactReasonSelect, "Contact Reason", reasonValue);
    }

    public void typeEmail(String email) {
        typeIntoElement(emailInput,"Email", email);
    }

    public void selectLocationByText(String locationText) {
        selectOptionByText(locationAreaSelect, "Location Area", locationText);
    }

    public void selectLocationByValue(String locationValue) {
        selectOptionByValue(locationAreaSelect, "Location Area", locationValue);
    }

    public void typeSubject(String subject) {
        typeIntoElement(subjectInput, "Subject", subject);
    }

    public void typeMessage(String message) {
        typeIntoElement(messageTextArea, "Message", message);
    }

    public String getPageName() {
        return getElementText(letsConnectTitle,"let's connect");
    }


}
