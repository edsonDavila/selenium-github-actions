package apex;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QualityAssuranceAndTestingPage {
    private WebDriverWait wdw;
    private WebDriver webDriver;
    private JavascriptExecutor js;
    @FindBy(xpath = "(//div[contains(@class,'view-leadership')]//a[@href = '/contact-us'])[2]")
    private WebElement connectWithUsLink;

    public QualityAssuranceAndTestingPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver,this);
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    public void scrollToConnectWithUsLink(){
        WebDriverWait wdw2;
        boolean exit = true;
        while (exit){
            try {
                wdw2 = new WebDriverWait(webDriver, Duration.ofSeconds(1));
                wdw2.until(ExpectedConditions.visibilityOf(connectWithUsLink));
                exit = false;
            }catch (Exception ex){
                js.executeScript("window.scrollBy(0,300)");
            }
        }
    }

    public void clickOnConnectWithUsLink(){
        this.wdw.until(ExpectedConditions.elementToBeClickable(connectWithUsLink));
        connectWithUsLink.click();
    }


}
