package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public static final String DEFAULT_URL = "https://www.saucedemo.com/";
    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public static LoginPage open(WebDriver driver) {
        driver.get(DEFAULT_URL);
        return new LoginPage(driver);
    }

    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputUserName(String data) {
        userNameField.sendKeys(data);
        return this;
    }

    public LoginPage inputPassword(String data) {
        passwordField.sendKeys(data);
        return this;

    }

    public LoginPage clearUserNameField(){
        userNameField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        return this;
    }

    public LoginPage clearPasswordField(){
        passwordField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        return this;
    }

    public SwagLabsPage clickLoginButton(){
        loginButton.click();
        return SwagLabsPage.waitUntilLoaded(driver);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public LoginPage clickSubmitAndAssertPageNotChanged() {
        try {
            clickLoginButton();
            throw new AssertionError("Logged in successfully");
        } catch (WebDriverException e) {
            return this;
        }
    }
}
