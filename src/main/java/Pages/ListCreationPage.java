package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListCreationPage extends BasePage{
    public ListCreationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class = 'a-alert-content' and text()='Please enter a name for the list.'] ")
    private WebElement listCreationErrorException;

    public WebElement getListCreationErrorException() {
        return listCreationErrorException;
    }

    public WebElement getListNameInputField() {
        return listNameInputField;
    }

    public WebElement getCreateListButton() {
        return createListButton.get(2);
    }

    @FindBy(xpath = "//input[contains (@class, 'a-input-text fix-width-x-large')]")
    private WebElement listNameInputField;
    @FindAll
    (@FindBy(xpath = "//input[@class='a-button-input a-declarative' and @type='submit']"))
    private List<WebElement> createListButton;

    public String getStringFromListCreationErrorException(){
        return listCreationErrorException.getText();
    }
    public void listWithoutNameCreation(){
        listNameInputField.clear();
        listNameInputField.sendKeys(Keys.ENTER);
    }
    public void clickCreateListButton(){
        createListButton.get(2).click();
    }

}
