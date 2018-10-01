package base.fragments;

import pages.*;
import org.openqa.selenium.*;

import static base.DriverHolder.driver;
import static org.testng.Assert.assertTrue;

/**
 * This class is used to reuse login process methods in all tests, where it is a precondition.
 */

public class LoginFragment {

    public static final String LOGIN = "Luke";
    public static final String PASSWORD = "Skywalker";
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("//p[@class='main-button'][text()='Logout']");
    private LoginPage loginPage = new LoginPage();
    private EmployeeListPage employeeListPage = new EmployeeListPage();

    public void loginToApp() {
        loginPage.waitForPageToLoad();
        loginPage.inputLoginName(LOGIN)
                .inputPassword(PASSWORD)
                .clickLoginButton();
        employeeListPage.checkUserIsOnEmployeeListPage();
    }

    public void logout() {
        getLogoutButton().click();
    }

    public void checkLogoutButtonIsDisplayed() {
        assertTrue(getLogoutButton().isDisplayed());
    }

    private WebElement getLogoutButton() {
        return driver.findElement(LOGOUT_BUTTON_LOCATOR);
    }
}
