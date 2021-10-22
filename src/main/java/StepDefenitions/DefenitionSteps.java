package StepDefenitions;

import Manager.PageFactoryManager;
import Pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefenitionSteps {
    WebDriver driver;
    private static final String MASSAGE_WHEN_USER_TRIES_CREATE_LIST_WITH_NO_NAME = "Please enter a name for the list.";
    private static final int RIGHT_COUNT_OF_RECOMMENDATIONS_ITEMS = 8;
    private static final long DEFAULT_TIMEOUT = 30;
    private static final String ADDITIONAL_MENU_HEADER_MASSAGE_WHEN_USER_NOT_LOGGED = "Hello, Sign in";
    private static final String ADDITIONAL_MENU_HEADER_MASSAGE_WHEN_USER_LOGGED = "Hello, Alex";
    private static final String MASSAGE_WHEN_INCORRECT_EMAIL_SET = "There was a problem";
    private static final String INCORRECT_EMAIL = "someincorrectemail@gmail.com";
    private static final String CORRECT_EMAIL = "amazontestingtask@gmail.com";
    private static final String CORRECT_PASSWORD = "amazontest123";
    private static final String LEARN_MORE_ABOUT_LIST = "Lists replaces wish lists and shopping lists, creating one place for all your lists";
    private static final String CORRECT_MASSAGE_FOR_OUT_OF_STOCK_ITEM = "Currently unavailable.\n" +
            "We don't know when or if this item will be back in stock.";
    private static final String EXPECTED_MASSAGE_IN_LIST_WITH_NO_ITEMS_FOOTER = "There are no items in this List.\n" +
            "Add items you want to shop for.";

    private HomePage homePage;
    private ListPage listPage;
    private SearchResultPage searchResultsPage;
    private ProductPage productPage;
    private PageFactoryManager pageFactoryManager;
    private SignInPage signInPage;
    private RecommendationItemsPage recommendationItemsPage;
    private ListCreationPage listCreationPage;

    @Before
    public void testsSetUp(){
        chromedriver().setup();
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens homepage")
    public void userOpensHomePagePage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage();
        homePage.WaitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @When("User clicks on additional menu button")
    public void userClicksOnAdditionalMenuButton() {
        homePage.waitForVisibilityofElement(DEFAULT_TIMEOUT, homePage.getAdditionalMenuButton());
        homePage.clickOnAdditionalMenuButton();
    }

    @Then("additional menu is visible to the User")
    public void additionalMenuIsVisibleToTheUser() {
        homePage.waitForVisibilityofElement(DEFAULT_TIMEOUT, homePage.getAdditionalMenu());
        assertTrue(homePage.checkThatAdditionalMenuIsVisible());
    }

    @Then("User checks that massage in additional menu header is Hello, Sign in")
    public void userChecksThatMassageInAdditionalMenuHeaderIsHelloSignIn() {
        homePage.waitForVisibilityofElement(DEFAULT_TIMEOUT, homePage.getAdditionalMenuHeader());
        assertEquals(ADDITIONAL_MENU_HEADER_MASSAGE_WHEN_USER_NOT_LOGGED, homePage.getMassageFromAdditionalMenuHeader());
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @And("User clicks massage for unsigned customers")
    public void userClicksMassageForUnsignedCustomers() {
        homePage.clickMassageFromAdditionalMenuHeader();
    }

    @And("User set incorrect email in email field on sign in page")
    public void userSetIncorrectEmailInEmailFieldOnSignInPage() {
        signInPage = pageFactoryManager.getSignInPage();
        homePage.waitForVisibilityofElement(DEFAULT_TIMEOUT, signInPage.getEmailFieldForSignIn());
        signInPage.setEmail(INCORRECT_EMAIL);
    }
    @And("User clicks continue button")
    public void userClicksContinueButton() {
        signInPage.clickContinueButton();
    }
    @Then("Massage about error is popup and equals to specific query for this scenario")
    public void massageAboutErrorIsPopupAndEqualsToSpecificQueryForThisScenario() {
        homePage.waitForVisibilityofElement(DEFAULT_TIMEOUT, signInPage.getExceptionHeader());
        assertEquals(MASSAGE_WHEN_INCORRECT_EMAIL_SET, signInPage.getStringFromExceptionHeader());
    }


    @When("User enter correct email in email field on sign in page")
    public void userEnterCorrectEmailInEmailFieldOnSignInPage() {
        signInPage = pageFactoryManager.getSignInPage();
        homePage.waitForVisibilityofElement(DEFAULT_TIMEOUT, signInPage.getEmailFieldForSignIn());
        signInPage.setEmail(CORRECT_EMAIL);
    }

    @And("User enter correct password in password input field")
    public void userEnterCorrectPasswordInPasswordInputField() {
        signInPage.inputPassword(CORRECT_PASSWORD);
    }

    @And("User clicks sign in button")
    public void userClicksSignInButton() throws InterruptedException {
        sleep(3000);
        signInPage.clickSignInButton();
    }

    @Then("User checks that additional menu header contains Hello, and his name")
    public void userChecksThatAdditionalMenuHeaderContainsHelloAndHisName() {
        homePage.waitForVisibilityofElement(DEFAULT_TIMEOUT, homePage.getAdditionalMenuHeader());
        assertEquals(ADDITIONAL_MENU_HEADER_MASSAGE_WHEN_USER_LOGGED, homePage.getMassageFromAdditionalMenuHeader());
    }

    @Given("User opens {string}")
    public void userOpensHomepage(String homePageUrl) {
        homePage = pageFactoryManager.getHomePage();
        driver.get(homePageUrl);
    }
    
    @When("User set {string} in the search field")
    public void userSetSearchKeysInTheSearchField(String searchProductByText) {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        homePage.setSearchInputField(searchProductByText);
    }

    @And("User clicks search submit button")
    public void userClicksSearchSubmitButton() {
        homePage.clickSearchSubmitButton();
    }

    @Then("User checks  product image of search result is visible")
    public void userChecksProductIntNumberOfSearchResultList() {
        assertTrue(searchResultsPage.searchResultProductImageIsVisible());
    }

    @And("User clicks on the first product of search result products list")
    public void userClicksOnTheFirstProductOfSearchResultProductsList() {
        searchResultsPage.clickOnProductAfterSearch();
        productPage = pageFactoryManager.getProductPage();
    }

    @When("User clicks on the add to list button on product page")
    public void userClicksOnTheAddToListButtonOnProductPage() {
        homePage.waitForVisibilityofElement(40, productPage.getAddToListButton());
        productPage.clickAddToListButton();
    }

    @Then("learn more about list field should contain specific key words")
    public void learnMoreAboutListFieldShouldContainSpecificKeyWords() {
        homePage.waitForVisibilityofElement(40, productPage.getLearnMoreSpanInfo());
        assertTrue(productPage.getStringFromLearnMoreElement().contains(LEARN_MORE_ABOUT_LIST));
    }

    @Then("User check there is special massage if product out of stock")
    public void userCheckThereIsSpecialMassageIfProductOutOfStock() {
        assertEquals(CORRECT_MASSAGE_FOR_OUT_OF_STOCK_ITEM, productPage.getStringFromOutOfStockMassage());
    }

    @When("User clicks cart button")
    public void userClicksCartButton() {
        homePage.clickCartButton();
    }

    @Then("User checks right amount of recommendations product categories must show up")
    public void userChecksRightAmountOfRecommendationsProductCategoriesMustShowUp() {
        recommendationItemsPage = pageFactoryManager.getRecommendationItemsPage();
        recommendationItemsPage.waitForVisibilityofElement(20, recommendationItemsPage.getRecommendationPageTitle());
        assertEquals(RIGHT_COUNT_OF_RECOMMENDATIONS_ITEMS, recommendationItemsPage.getRecommendationItemsListSize());
    }
    @And("User clicks recommended items button")
    public void userClicksRecommendedItemsButton() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage.clickRecommendedForYouButton();
    }

    @And("User goes to account menu")
    public void userGoesToAccountMenu() {
        homePage.interactWithUserActionsMenu();
    }

    @And("User clicks create a list button")
    public void userClicksCreateAListButton() {
        homePage.clickCreateListButton();
    }

    @When("User don't input in list name any value")
    public void userTriesToCreateNewListWithoutListName() {
        listCreationPage = pageFactoryManager.getListCreationPage();
        homePage.waitForVisibilityofElement(30, listCreationPage.getListNameInputField());
        listCreationPage.listWithoutNameCreation();
    }

    @Then("User can see specific error massage")
    public void userCanSeeSpecificErrorMassage() {
        assertEquals(MASSAGE_WHEN_USER_TRIES_CREATE_LIST_WITH_NO_NAME, listCreationPage.getStringFromListCreationErrorException());
    }

    @And("User clicks create list button")
    public void userClicksCreateListButton() {
        listCreationPage.clickCreateListButton();
    }

    @Then("User see {string} about item adding to the wishlist")
    public void userSeeMassageAboutItemAddingToTheWishlist(final String expectedMassageAtTheHeader) {
        assertEquals(expectedMassageAtTheHeader, productPage.getStringFromAddToListHeader());
    }

    @When("User wants to delete products from list he clicks all delete buttons in his list")
    public void userWantsToDeleteProductsFromListHeClicksAllDeleteButtonsInHisList() {
        listPage = pageFactoryManager.getListpage();
        listPage.clickAllDeleteFromListButtons();
    }

    @And("User refresh list page")
    public void userRefreshListPage() {
        listPage.refreshListPage();
    }

    @Then("User checks that his list is empty and see massage")
    public void userChecksThatHisListIsEmptyAndSeeMassage() {
        assertEquals(EXPECTED_MASSAGE_IN_LIST_WITH_NO_ITEMS_FOOTER, listPage.getStringNoItemsInListFooter());
    }

    @And("User opens his shopping list")
    public void userOpensHisShoppingList() {
        homePage.clickShoppingListButton();
    }
}