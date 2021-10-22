package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLearnMoreSpanInfo() {
        return learnMoreSpanInfo;
    }

    public WebElement getAddToListButton() {
        return addToListButton;
    }

    public WebElement getLearnMoreButton() {
        return learnMoreButton;
    }

    @FindBy(xpath = "//span[contains(@class, 'a-button a-button-groupfirst')]")
    private WebElement addToListButton;

    @FindBy(xpath = "//a[@class= 'a-popover-trigger a-declarative' and text()='Learn more']")
    private WebElement learnMoreButton;

    @FindBy(xpath = "//div[@class= 'a-popover-content' and contains(@id, '5')]")
    private WebElement learnMoreSpanInfo;

    @FindBy(xpath = "//div[@class= 'a-section a-spacing-small a-text-center']")
    private WebElement outOfStockMassage;

    @FindBy(xpath = "//div[@class= 'w-popover-header']")
    private WebElement addToListHeader;


    public void clickAddToListButton(){
        addToListButton.click();
    }
    public void clickLearnMore(){
        learnMoreButton.click();
    }
    public String getStringFromLearnMoreElement(){
        return learnMoreSpanInfo.getText();
    }
    public String getStringFromOutOfStockMassage(){
        return outOfStockMassage.getText();
    }

    public String getStringFromAddToListHeader(){
        waitForVisibilityofElement(20, addToListHeader);
        return addToListHeader.getText();
    }
}
