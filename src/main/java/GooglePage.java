import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePage {
    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(xpath = "(//h3[text() = 'Apex Systems'])[1]")
    private WebElement apexLink;
    private WebDriverWait wdw;
    public GooglePage(WebDriver driver){
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void typeSearchBar(String text){
        this.wdw.until(ExpectedConditions.visibilityOf(searchBar));
        this.searchBar.sendKeys(text);
        this.searchBar.sendKeys(Keys.ENTER);
    }

    public String getLinkText(){
        this.wdw.until(ExpectedConditions.visibilityOf(apexLink));
        return apexLink.getText();
    }

}
