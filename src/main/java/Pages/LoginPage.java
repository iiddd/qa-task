package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.reporters.XMLReporterConfig.ATTR_CLASS;

/**
 * This class is used to store all Login page methods
 */

public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD_LOCATOR = By.xpath("//span[text()='Username*']/following-sibling::input");
    private static final By PASSWORD_FIELD_LOCATOR = By.xpath("//span[text()='Password*']/following-sibling::input");
    private static final By ERROR_MESSAGE_LOCATOR = By.cssSelector(".error-message");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@class='main-button']");
    private static final String IS_VALID_PARTIAL_CLASSNAME = "ng-valid";
    private static final String ATTR_DISABLED = "ng-disabled";
    private static final String ERROR_MESSAGE_TEXT = "Invalid username or password!";

    public LoginPage inputLoginName(String inputText) {
        getUserNameField().clear();
        getUserNameField().sendKeys(inputText);
        return this;
    }

    public LoginPage inputPassword(String inputText) {
        getPasswordField().clear();
        getPasswordField().sendKeys(inputText);
        return this;
    }

    public LoginPage clickLoginButton() {
        //javascript used here to avoid browser security tooltips issues
        try {
            getLoginButton().click();
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", getLoginButton());
        }
        return this;
    }

    public LoginPage checkLoginButtonIsDisabled() {
        assertTrue(Boolean.valueOf(getLoginButton().getAttribute(ATTR_DISABLED)));
        return this;
    }

    public LoginPage checkUserNameFieldIsValid() {
        assertTrue(getUserNameField().getAttribute(ATTR_CLASS).contains(IS_VALID_PARTIAL_CLASSNAME));
        return this;
    }

    public LoginPage checkPasswordFieldIsValid() {
        assertTrue(getPasswordField().getAttribute(ATTR_CLASS).contains(IS_VALID_PARTIAL_CLASSNAME));
        return this;
    }

    public LoginPage checkLoginFieldIsDisplayed() {
        assertTrue(getUserNameField().isDisplayed());
        return this;
    }

    public LoginPage checkPasswordFieldIsDisplayed() {
        assertTrue(getPasswordField().isDisplayed());
        return this;
    }

    public LoginPage checkLoginButtonIsDisplayed() {
        assertTrue(getLoginButton().isDisplayed());
        return this;
    }

    public LoginPage checkErrorMessageText() {
        assertEquals(getErrorMessage().getText(), ERROR_MESSAGE_TEXT);
        return this;
    }

    public LoginPage checkErrorMessageIsDisplayed() {
        waitForPageLoaded();
        assertTrue(getErrorMessage().isDisplayed());
        return this;
    }

    private WebElement getUserNameField() {
        return driver.findElement(USERNAME_FIELD_LOCATOR);
    }

    private WebElement getPasswordField() {
        return driver.findElement(PASSWORD_FIELD_LOCATOR);
    }

    private WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON_LOCATOR);
    }

    private WebElement getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE_LOCATOR);
    }
}