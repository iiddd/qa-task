package pages;

import base.models.EmployeeData;
import base.utils.RandomUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static base.Constants.*;
import static base.DriverHolder.getDriver;
import static org.testng.Assert.*;
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
    private static final String SEARCH_EMPLOYEE_BY_NAME_ERROR_MESSAGE = "More than one or no employee list items with such name were found";
    private static final String DISABLED_ATTR = "disabled";
    private static final String JS_SCROLL_INTOVIEW_SCRIPT = "arguments[0].scrollIntoView(true);";

    public EmployeeListPage checkUserIsOnEmployeeListPage() {
        waitForPageToLoad();
        assertEquals(getDriver().getCurrentUrl(), EMPLOYEE_LIST_PAGE_URL);
        return this;
    }

    public EmployeeListPage checkDeletePopUpTextByEmployeeData(EmployeeData employeeData) {
        String expectedText = String.format("Are you sure you want to delete %s %s?", employeeData.getFirstName(), employeeData.getLastName());
        assertEquals(getDriver().switchTo().alert().getText(), expectedText);
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
        assertTrue(getEmployeeListByPartialName(name).size() < 1);
        return this;
    }

    public EmployeeListPage openEmployeeProfileWithDoubleClickByPartialName(String name) {
        doubleClickByElement(getEmployeeListItemByPartialName(name));
        return this;
    }

    public EmployeeListPage selectEmployeeProfileByPartialName(String name) {
        waitForPageToLoad();
        getEmployeeListItemByPartialName(name).click();
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
        waitForPageToLoad();
        return this;
    }

    public EmployeeListPage declineDeleteConfirmation() {
        getDriver().switchTo().alert().dismiss();
        return this;
    }

    public EmployeeListPage acceptDeleteConfirmation() {
        getDriver().switchTo().alert().accept();
        //waiting for delete
        waitForSomeTime(2000);
        return this;
    }

    public String getRandomEmployeeListProfileName() {
        return RandomUtils.getRandomElementFromList(getListOfEmployee()).getText();
    }

    private void doubleClickByElement(WebElement element) {
        //Since gecko driver has issue with actions.moveToElement, I have to scroll into view with JS
        scrollToElementWithJS(element);
        new Actions(getDriver()).moveToElement(element).doubleClick().perform();
    }

    private void scrollToElementWithJS(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript(JS_SCROLL_INTOVIEW_SCRIPT, element);
    }

    private WebElement getCreateButton() {
        return getDriver().findElement(CREATE_BUTTON_LOCATOR);
    }

    private WebElement getEditButton() {
        return getDriver().findElement(EDIT_BUTTON_LOCATOR);
    }

    private WebElement getDeleteButton() {
        return getDriver().findElement(DELETE_BUTTON_LOCATOR);
    }

    private WebElement getEmployeeListElement() {
        return getDriver().findElement(EMPLOYEE_LIST_LOCATOR);
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
        return getDriver().findElements(EMPLOYEE_LIST_ITEM_LOCATOR);
    }
}
