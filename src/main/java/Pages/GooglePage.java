package Pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class GooglePage extends PageManageActions{
    @FindBy(name = "q")
    private WebElement searchBar;
    @FindBy(xpath = "(//h3[text() = 'Apex Systems'])[1]")
    private WebElement apexLink;

    public GooglePage(WebDriver driver, ExtentTest test){
        super(driver,test);
        PageFactory.initElements(driver,this);
    }

    public void typeSearchBar(String text){
        typeIntoElement(searchBar,"Search Bar", text + Keys.ENTER);
    }

    public String getLinkText(){
       return getElementText(apexLink, "Apex Link");
    }

}
