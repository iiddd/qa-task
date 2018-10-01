package pages;

import base.models.EmployeeData;
import org.openqa.selenium.*;

import static base.Constants.ATTR_VALUE;
import static base.DriverHolder.getDriver;
import static org.testng.Assert.*;

/**
 * This class is used to store common elements and locators for Create Employee page and Edit Employee page
 */

public class BaseProfilePage<T extends BaseProfilePage> extends BasePage {

    private static final By FIRST_NAME_FIELD_LOCATOR = By.xpath("//span[text()='First name:']/following-sibling::input");
    private static final By LAST_NAME_FIELD_LOCATOR = By.xpath("//span[text()='Last name:']/following-sibling::input");
    private static final By DATE_FIELD_LOCATOR = By.xpath("//span[text()='Start date:']/following-sibling::input");
    private static final By EMAIL_FIELD_LOCATOR = By.xpath("//span[text()='Email:']/following-sibling::input");

    public T checkFirstName(String firstName) {
        assertEquals(getEmployeeData().getFirstName(), firstName);
        return (T) this;
    }

    public T checkLastName(String lastName) {
        assertEquals(getEmployeeData().getLastName(), lastName);
        return (T) this;
    }

    public T checkStartDate(String startDate) {
        assertEquals(getEmployeeData().getStartDate(), startDate);
        return (T) this;
    }

    public T checkEmailAddress(String email) {
        assertEquals(getEmployeeData().getEmail(), email);
        return (T) this;
    }

    public T checkFirstNameFieldIsDisplayed() {
        assertTrue(getFirstNameField().isDisplayed());
        return (T) this;
    }

    public T checkLastNameFieldIsDisplayed() {
        assertTrue(getLastNameField().isDisplayed());
        return (T) this;
    }

    public T checkDateFieldIsDisplayed() {
        assertTrue(getDateField().isDisplayed());
        return (T) this;
    }

    public T checkEmailFieldIsDisplayed() {
        assertTrue(getEmailField().isDisplayed());
        return (T) this;
    }

    public T fillFirstNameField(String firstName) {
        clearFirstNameField();
        getFirstNameField().sendKeys(firstName);
        return (T) this;
    }

    public T fillLastNameField(String firstName) {
        clearLastNameField();
        getLastNameField().sendKeys(firstName);
        return (T) this;
    }

    public T fillDateField(String firstName) {
        clearDateField();
        getDateField().sendKeys(firstName);
        return (T) this;
    }

    public T fillEmailField(String firstName) {
        clearEmailField();
        getEmailField().sendKeys(firstName);
        return (T) this;
    }

    public T clearFirstNameField() {
        getFirstNameField().clear();
        return (T) this;
    }

    public T clearLastNameField() {
        getLastNameField().clear();
        return (T) this;
    }

    public T clearDateField() {
        getDateField().clear();
        return (T) this;
    }

    public T clearEmailField() {
        getEmailField().clear();
        return (T) this;
    }

    public EmployeeData getEmployeeData() {
        return new EmployeeData()
                .setFirstName(getEmployeeProfileFirstName())
                .setLastName(getEmployeeProfileLastName())
                .setStartDate(getEmployeeProfileStartDate())
                .setEmail(getEmployeeProfileEmail());
    }

    private String getEmployeeProfileFirstName() {
        return getFirstNameField().getAttribute(ATTR_VALUE);
    }

    private String getEmployeeProfileLastName() {
        return getLastNameField().getAttribute(ATTR_VALUE);
    }

    private String getEmployeeProfileStartDate() {
        return getDateField().getAttribute(ATTR_VALUE);
    }

    private String getEmployeeProfileEmail() {
        return getEmailField().getAttribute(ATTR_VALUE);
    }

    public WebElement getFirstNameField() {
        return getDriver().findElement(FIRST_NAME_FIELD_LOCATOR);
    }

    public WebElement getLastNameField() {
        return getDriver().findElement(LAST_NAME_FIELD_LOCATOR);
    }

    public WebElement getDateField() {
        return getDriver().findElement(DATE_FIELD_LOCATOR);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(EMAIL_FIELD_LOCATOR);
    }
}
