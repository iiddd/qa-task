package Pages;

import Base.Models.EmployeeData;
import Base.Utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static Base.Constants.ATTR_CLASS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * This class is used to store all Employee list page methods
 */

public class EmployeeListPage extends BasePage {

    private static final By CREATE_BUTTON_LOCATOR = By.id("bAdd");
    private static final By EDIT_BUTTON_LOCATOR = By.id("bEdit");
    private static final By DELETE_BUTTON_LOCATOR = By.id("bDelete");
    private static final By EMPLOYEE_LIST_LOCATOR = By.id("employee-list");
    private static final By EMPLOYEE_LIST_ITEM_LOCATOR = By.xpath("//li[@ng-repeat='employee in employees']");
    private static final String EMPLOYEE_LIST_PAGE_URL = "http://cafetownsend-angular-rails.herokuapp.com/employees";
    private static final String SEARCH_EMPLOYEE_BY_NAME_ERROR_MESSAGE = "More than one or no employee list items with such name were found";
    private static final String DISABLED_ATTR = "disabled";
    private static final String JS_SCROLL_INTOVIEW_SCRIPT = "arguments[0].scrollIntoView(true);";

    public EmployeeListPage checkUserIsOnEmployeeListPage() {
        waitForPageLoaded();
        assertEquals(driver.getCurrentUrl(), EMPLOYEE_LIST_PAGE_URL);
        return this;
    }

    public EmployeeListPage checkDeletePopUpTextByEmployeeData(EmployeeData employeeData) {
        String expectedText = String.format("Are you sure you want to delete %s %s?", employeeData.getFirstName(), employeeData.getLastName());
        assertEquals(driver.switchTo().alert().getText(), expectedText);
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
        assertTrue(getEditButton().getAttribute(ATTR_CLASS).contains(DISABLED_ATTR));
        return this;
    }

    public EmployeeListPage checkDeleteButtonIsDisabled() {
        assertTrue(getDeleteButton().getAttribute(ATTR_CLASS).contains(DISABLED_ATTR));
        return this;
    }

    public EmployeeListPage checkDeleteButtonIsEnabled() {
        assertFalse(getDeleteButton().getAttribute(ATTR_CLASS).contains(DISABLED_ATTR));
        return this;
    }

    public EmployeeListPage checkEditButtonIsEnabled() {
        assertFalse(getEditButton().getAttribute(ATTR_CLASS).contains(DISABLED_ATTR));
        return this;
    }

    public EmployeeListPage checkEmployeeIsInTheListByPartialName(String name) {
        WebElement employeeListItem = getEmployeeListItemByPartialName(name);
        scrollToElementWithJS(employeeListItem);
        assertTrue(employeeListItem.isDisplayed());
        return this;
    }

    public EmployeeListPage checkEmployeeIsAbsentInListByPartialName(String name) {
        //waiting for delete
        waitForSomeTime(2000);
        assertTrue(getEmployeeListByPartialName(name).size() < 1);
        return this;
    }

    public EmployeeListPage openEmployeeProfileWithDoubleClickByPartialName(String name) {
        doubleClickByElement(getEmployeeListItemByPartialName(name));
        return this;
    }

    public EmployeeListPage selectEmployeeProfileByPartialName(String name) {
        waitForPageLoaded();
        (getEmployeeListItemByPartialName(name)).click();
        return this;
    }

    public EmployeeListPage clickCreateButton() {
        getCreateButton().click();
        return this;
    }

    public EmployeeListPage clickEditButton() {
        getEditButton().click();
        return this;
    }

    public EmployeeListPage clickDeleteButton() {
        getDeleteButton().click();
        waitForPageLoaded();
        return this;
    }

    public EmployeeListPage declineDeleteConfirmation() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public EmployeeListPage acceptDeleteConfirmation() {
        driver.switchTo().alert().accept();
        return this;
    }

    public String getRandomEmployeeListProfileName() {
        return RandomUtils.getRandomElementFromList(getListOfEmployee()).getText();
    }

    private void doubleClickByElement(WebElement element) {
        //Since gecko driver has issue with actions.moveToElement, I have to scroll into view with JS
        scrollToElementWithJS(element);
        new Actions(driver).moveToElement(element).doubleClick().perform();
    }

    private void scrollToElementWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(JS_SCROLL_INTOVIEW_SCRIPT, element);
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

    private WebElement getEmployeeListItemByPartialName(String name) {
        List<WebElement> resultList = getEmployeeListByPartialName(name);
        if (resultList.size() == 0 || resultList.size() > 1) {
            Logger.getGlobal().info(SEARCH_EMPLOYEE_BY_NAME_ERROR_MESSAGE);
        }
        return resultList.get(0);
    }

    private List<WebElement> getEmployeeListByPartialName(String name) {
        return getListOfEmployee()
                .stream()
                .filter(employeeElement -> employeeElement.getText().contains(name))
                .collect(Collectors.toList());
    }

    private List<WebElement> getListOfEmployee() {
        return driver.findElements(EMPLOYEE_LIST_ITEM_LOCATOR);
    }
}
