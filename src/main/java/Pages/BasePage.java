package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void WaitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForVisibilityofElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTheMouseMoveToElement(long timeToWait, WebElement element) {
        WebDriverWait waitForTheElement = new WebDriverWait(driver, timeToWait);
                waitForTheElement.until(ExpectedConditions.elementToBeClickable(element));
    }
}
