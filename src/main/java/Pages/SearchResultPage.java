package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    @FindAll(@FindBy(xpath = "//img[@class = 's-image']"))
    private List<WebElement> searchResultProductsList;

    public void clickOnProductAfterSearch(){
        searchResultProductsList.get(0).click();
    }

    public boolean searchResultProductImageIsVisible(){
        var displayed = searchResultProductsList.get(0).isDisplayed();
        return displayed;
    }
}
