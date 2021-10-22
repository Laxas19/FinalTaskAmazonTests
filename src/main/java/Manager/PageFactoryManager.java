package Manager;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage getHomePage(){
        return new  HomePage(driver);
    }
    public ListPage getListpage(){
        return new ListPage(driver);
    }
    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }
    public SignInPage getSignInPage(){
        return new SignInPage(driver);
    }
    public SearchResultPage getSearchResultPage(){
        return new SearchResultPage (driver);
    }
    public RecommendationItemsPage getRecommendationItemsPage(){
        return new RecommendationItemsPage(driver);
    }
    public ListCreationPage getListCreationPage(){
        return new ListCreationPage(driver);
    }
}
