package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailFieldForSignIn() {
        return emailFieldForSignIn;
    }

    public WebElement getExceptionHeader() {
        return exceptionHeader;
    }

    @FindBy (xpath = "//input[@type ='email']")
    private WebElement emailFieldForSignIn;

    @FindBy (xpath = "//h4[@class='a-alert-heading']")
    private WebElement exceptionHeader;

    @FindBy (xpath = "//input[@class='a-button-input']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[contains(@class, 'a-input-text a-span12')]")
    private WebElement passwordFieldForSignin;

    @FindBy(xpath = "//input[contains(@class, 'a-button-input')]")
    private WebElement signInButton;

    public void setEmail(final String email){
        emailFieldForSignIn.sendKeys(email);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public String getStringFromExceptionHeader(){
        return exceptionHeader.getText();
    }
    public void inputPassword(final String pass){
        passwordFieldForSignin.sendKeys(pass);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
}
