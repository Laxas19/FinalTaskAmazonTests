package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListPage extends BasePage{
    public ListPage(WebDriver driver) {
        super(driver);
    }
    @FindAll(@FindBy(xpath = "//input[@class= 'a-button-input a-declarative' and @name='submit.deleteItem']"))
    private List <WebElement> allDeleteFromListButtons;

    @FindBy(xpath = "//span[@class= 'a-size-medium']")
    private WebElement noItemsInListFooter;

    public void clickAllDeleteFromListButtons(){
        waitForVisibilityofElement(20, allDeleteFromListButtons.get(0));
        allDeleteFromListButtons.forEach(webelement->webelement.click());
    }
    public String getStringNoItemsInListFooter() {
        return noItemsInListFooter.getText();
    }
    public void refreshListPage(){
        driver.navigate().refresh();
    }


}
