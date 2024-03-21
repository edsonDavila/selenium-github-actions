package apex;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApexPage {
    @FindBy(xpath = "//button[@data-target = '#navbarSupportedContent']")
    private WebElement navBarButton;
    @FindBy(xpath = "(//a[text() = 'Search'])[1]")
    private WebElement searchButton;
    @FindBy(id = "edit-sq")
    private WebElement searchInput;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookiesAlert;
    private WebDriverWait wdw;

    public ApexPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnNavBarMenuButton(){
        this.wdw.until(ExpectedConditions.elementToBeClickable(navBarButton));
        navBarButton.click();
    }

    public void clickOnAcceptCookiesButton(){
        this.wdw.until(ExpectedConditions.elementToBeClickable(cookiesAlert));
        cookiesAlert.click();
    }
}
