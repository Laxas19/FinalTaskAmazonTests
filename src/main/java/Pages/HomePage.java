package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";

    @FindBy (xpath = "//i[@class='hm-icon nav-sprite']")
    private WebElement additionalMenuButton;

    @FindBy (xpath = "//div[@id='hmenu-content']")
    private WebElement additionalMenu;

    @FindBy (xpath = "//div[@id ='hmenu-customer-profile-right']")
    private WebElement additionalMenuHeader;

    @FindBy(xpath = "//input[@class='nav-input nav-progressive-attribute' and @type = 'text']")
    private WebElement searchInputField;

    @FindBy(xpath = "//input[@class = 'nav-input nav-progressive-attribute' and @type='submit']")
    private WebElement searchSubmitButton;

    @FindBy(xpath = "//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
    private WebElement cartButton;
    @FindBy(xpath = "//a[contains(@class, 'nav-truncate   nav-progressive-attribute')]")
    private WebElement userActionsMenu;
    @FindBy(xpath = "//a[span [@class = 'nav-text' and text()='Create a List']]")
    private WebElement createListButton;
    @FindBy(xpath = "//span[@class= 'nav-text' and text()='Shopping List ']")
    private WebElement shoppingListButton;

    public WebElement getAdditionalMenuButton() {
        return additionalMenuButton;
    }
    @FindBy(xpath = "//a[@id='nav-your-amazon']")
    private WebElement yourAmazonButton;

    public void clickRecommendedForYouButton(){
        yourAmazonButton.click();
    }
    public WebElement getAdditionalMenu() {
        return additionalMenu;
    }

    public WebElement getAdditionalMenuHeader() {
        return additionalMenuHeader;
    }

    public void openHomePage(){
        driver.get(AMAZON_HOME_PAGE_URL);
    }
    public void clickOnAdditionalMenuButton(){
        additionalMenuButton.click();
    }
    public boolean checkThatAdditionalMenuIsVisible(){
       return additionalMenu.isDisplayed();
    }
    public String getMassageFromAdditionalMenuHeader(){
        return additionalMenuHeader.getText();
    }
    public void clickMassageFromAdditionalMenuHeader(){
        additionalMenuHeader.click();
    }
    public void setSearchInputField(final String searchKeys){
        searchInputField.clear();
        searchInputField.sendKeys(searchKeys);
    }
    public void clickSearchSubmitButton(){
        searchSubmitButton.click();
    }
    public void clickCartButton(){
        cartButton.click();
    }
    public void interactWithUserActionsMenu(){
        Actions action = new Actions(driver);
        action.moveToElement(userActionsMenu);
    }
    public void clickCreateListButton(){
        Actions builder = new Actions(driver);
        builder.moveToElement(userActionsMenu).perform();
        waitForTheMouseMoveToElement(20, createListButton);
        builder.moveToElement(createListButton).click().perform();
    }
    public void clickShoppingListButton(){
        Actions builder = new Actions(driver);
        builder.moveToElement(userActionsMenu).perform();
        waitForTheMouseMoveToElement(20, shoppingListButton);
        builder.moveToElement(shoppingListButton).click().perform();
    }
}
