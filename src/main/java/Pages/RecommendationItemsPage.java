package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RecommendationItemsPage extends BasePage{
    public RecommendationItemsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRecommendationPageTitle() {
        return recommendationPageTitle;
    }

    @FindAll(@FindBy(xpath= "//div[@class='overlay']"))
    private List<WebElement> recommendationItemsList;

    @FindBy(xpath = "//div[@class='np-grid-title']")
    private WebElement recommendationPageTitle;

    public List<WebElement> getRecommendationItemsList() {
        return recommendationItemsList;
    }

    public int getRecommendationItemsListSize(){
       return recommendationItemsList.size();
    }
}
