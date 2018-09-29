package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.reporters.XMLReporterConfig.ATTR_CLASS;

/**
 * This class is used to store all Employee list page methods
 */

public class EmployeeListPage extends BasePage {

    private static final String EMPLOYEE_LIST_PAGE_URL = "http://cafetownsend-angular-rails.herokuapp.com/employees";
    private static final By CREATE_BUTTON_LOCATOR = By.id("bAdd");
    private static final By EDIT_BUTTON_LOCATOR = By.id("bEdit");
    private static final By DELETE_BUTTON_LOCATOR = By.id("bDelete");
    private static final By EMPLOYEE_LIST_LOCATOR = By.id("employee-list");

    public EmployeeListPage checkUserIsOnEmployeeListPage() {
        waitForPageLoaded();
        assertEquals(driver.getCurrentUrl(), EMPLOYEE_LIST_PAGE_URL);
        return this;
    }

    public EmployeeListPage checkCreateButtonIsDisplayed() {
        assertTrue(getCreateButton().isDisplayed());
        return this;
    }

    public EmployeeListPage checkEditButtonIsDisplayed() {
        assertTrue(getEditButton().isDisplayed());
        return this;
    }

    public EmployeeListPage checkDeleteButtonIsDisplayed() {
        assertTrue(getDeleteButton().isDisplayed());
        return this;
    }

    public EmployeeListPage checkEmployeeListIsDisplayed() {
        assertTrue(getEmployeeListElement().isDisplayed());
        return this;
    }

    public EmployeeListPage checkLogoutButtonIsDisplayed() {
        assertTrue(getEditButton().isDisplayed());
        return this;
    }

    public EmployeeListPage checkEditButtonIsDisabled() {
        assertTrue(getEditButton().getAttribute(ATTR_CLASS).contains("disabled"));
        return this;
    }

    public EmployeeListPage checkDeleteButtonIsDisabled() {
        assertTrue(getDeleteButton().getAttribute(ATTR_CLASS).contains("disabled"));
        return this;
    }

    private WebElement getCreateButton() {
        return driver.findElement(CREATE_BUTTON_LOCATOR);
    }

    private WebElement getEditButton() {
        return driver.findElement(EDIT_BUTTON_LOCATOR);
    }

    private WebElement getDeleteButton() {
        return driver.findElement(DELETE_BUTTON_LOCATOR);
    }

    private WebElement getEmployeeListElement() {
        return driver.findElement(EMPLOYEE_LIST_LOCATOR);
    }
}
