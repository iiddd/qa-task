package Pages;

import Base.BasePage;
import Base.Models.EmployeeData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * This page is used to store all Employee profile page methods
 */

public class EmployeeProfilePage extends BasePage {

    private static final String ATTR_VALUE = "value";
    private static final String EMPLOYEE_PROFILE_PAGE_URL_PATTERN = "(http://cafetownsend-angular-rails.herokuapp.com/employees/)+([0-9]+)+/edit";
    private static final By FIRST_NAME_FIELD_LOCATOR = By.xpath("//span[text()='First name:']/following-sibling::input");
    private static final By LAST_NAME_FIELD_LOCATOR = By.xpath("//span[text()='Last name:']/following-sibling::input");
    private static final By DATE_FIELD_LOCATOR = By.xpath("//span[text()='Start date:']/following-sibling::input");
    private static final By EMAIL_FIELD_LOCATOR = By.xpath("//span[text()='Email:']/following-sibling::input");
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("//p[@class='main-button'][text()='Logout']");
    private static final By BACK_BUTTON_LOCATOR = By.cssSelector(".subButton.bBack");
    private static final By UPDATE_BUTTON_LOCATOR = By.xpath("//button[@class='main-button']");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//p[@class='main-button'][text()='Delete']");

    public EmployeeProfilePage checkUserIsOnEmployeeProfilePage() {
        waitForPageLoaded();
        Pattern pattern = Pattern.compile(EMPLOYEE_PROFILE_PAGE_URL_PATTERN);
        Matcher matcher = pattern.matcher(driver.getCurrentUrl());
        assertTrue(matcher.find());
        return this;
    }

    public EmployeeProfilePage checkFirstName(String firstName) {
        assertEquals(getEmployeeData().getFirstName(), firstName);
        return this;
    }

    public EmployeeProfilePage checkLastName(String lastName) {
        assertEquals(getEmployeeData().getLastName(), lastName);
        return this;
    }

    public EmployeeProfilePage checkStartDate(String startDate) {
        assertEquals(getEmployeeData().getStartDate(), startDate);
        return this;
    }

    public EmployeeProfilePage checkEmailAdress(String email) {
        assertEquals(getEmployeeData().getEmail(), email);
        return this;
    }

    private EmployeeData getEmployeeData() {
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

    private WebElement getFirstNameField() {
        return driver.findElement(FIRST_NAME_FIELD_LOCATOR);
    }

    private WebElement getLastNameField() {
        return driver.findElement(LAST_NAME_FIELD_LOCATOR);
    }

    private WebElement getDateField() {
        return driver.findElement(DATE_FIELD_LOCATOR);
    }

    private WebElement getEmailField() {
        return driver.findElement(EMAIL_FIELD_LOCATOR);
    }

    private WebElement getLogoutButton() {
        return driver.findElement(LOGOUT_BUTTON_LOCATOR);
    }

    private WebElement getBackButton() {
        return driver.findElement(BACK_BUTTON_LOCATOR);
    }

    private WebElement getUpdateButton() {
        return driver.findElement(UPDATE_BUTTON_LOCATOR);
    }

    private WebElement getDeleteButton() {
        return driver.findElement(DELETE_BUTTON_LOCATOR);
    }
}
