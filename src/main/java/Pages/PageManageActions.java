package Pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageManageActions {

    protected WebDriver driver;
    protected ExtentTest test;
    private WebDriverWait wdw;
    private JavascriptExecutor js;
    private Actions actions;



    public PageManageActions(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);

    }

    public void waitUntilElementIsClickableAndClick(WebElement element, String elementDescription) {
        try {
            //test.info("waiting until " + elementDescription + "is visible");
            wdw.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            test.pass("CLICKED -- "+ elementDescription);
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + " Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail("Time to locate " + elementDescription + " finished. "+elementDescription +" Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        } catch (ElementClickInterceptedException ex) {
            test.fail(elementDescription + " Element was intercepted by another element in the page");
            throw ex;
        }
    }

    public void scrollToElement(WebElement element, String elementDescription) {
        try {
            WebDriverWait wdw2;
            boolean exit = true;
            while (exit){
                try {
                    wdw2 = new WebDriverWait(driver, Duration.ofSeconds(1));
                    wdw2.until(ExpectedConditions.visibilityOf(element));
                    exit = false;
                }catch (Exception ex){
                    js.executeScript("window.scrollBy(0,300)");
                }
            }
            test.pass("SCROLL to "+ elementDescription + " element");
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + " Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail("Time to locate " + elementDescription + " finished. Search bar Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        }
    }

    public void typeIntoElement(WebElement element, String elementDescription,String text) {
        try {
            wdw.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
            test.pass("TYPE -- "+ elementDescription + " -- " + text);
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + " Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail(" Time to locate" + elementDescription + " finished. Search bar Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        }
    }

    public void selectOptionByText(WebElement element, String elementDescription,String text) {
        try {
            wdw.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);
            select.selectByVisibleText(text);
            test.pass("Selected "+text+" option into "+ elementDescription + " element");
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + "Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail("Time to locate " + elementDescription + " finished. Search bar Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        }
    }

    public void selectOptionByValue(WebElement element, String elementDescription,String value) {
        try {
            wdw.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);
            select.selectByValue(value);
            test.pass("Selected "+value+" option into "+ elementDescription + " element");
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + " Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail("Time to locate " + elementDescription + " finished. Search bar Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        }
    }

    public String getElementText(WebElement element, String elementDescription) {
        try {
            wdw.until(ExpectedConditions.visibilityOf(element));
            String elementText = element.getText();
            test.pass("Obtained '"+ elementText +"' text from "+ elementDescription + " element");
            return elementText;
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + " Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail("Time to locate " + elementDescription + " finished. Search bar Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        }
    }

    public String getElementTextJS(WebElement element, String elementDescription) {
        try {
            Thread.sleep(Duration.ofSeconds(5).toMillis());
            String elementText = (String) js.executeScript("return arguments[0].innerText;", element);
            test.pass("Obtained '"+ elementText +"' text from "+ elementDescription + " element");
            return elementText;
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + " Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail("Time to locate " + elementDescription + " finished. Search bar Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hoverElement(WebElement element, String elementDescription) {
        try {
            this.wdw.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element).perform();
            test.pass("HOVER -- "+ elementDescription + " element");
        } catch (NoSuchElementException ex) {
            test.fail(elementDescription + " Element not Located");
            throw ex;
        } catch (TimeoutException ex) {
            test.fail("Time to locate " + elementDescription + " finished. Search bar Element not Located");
            throw ex;
        } catch (StaleElementReferenceException ex) {
            test.fail(elementDescription + " Element not found on DOM");
            throw ex;
        }
    }

    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        test.pass("waiting for "+ seconds +" seconds");
    }

    public void waitThread(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(5).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        test.pass("waiting for "+ seconds +" seconds");
    }

}
