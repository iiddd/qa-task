package pages;

import base.models.EmployeeData;
import org.openqa.selenium.*;

import java.util.regex.*;

import static base.DriverHolder.getDriver;
import static org.testng.Assert.*;

/**
 * This page is used to store all Employee profile page methods
 */

public class EditProfilePage extends BaseProfilePage<EditProfilePage> {

    private static final String EMPLOYEE_PROFILE_PAGE_URL_PATTERN = "(http://cafetownsend-angular-rails.herokuapp.com/employees/)+([0-9]+)+/edit";
    private static final By UPDATE_BUTTON_LOCATOR = By.xpath("//button[@class='main-button']");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//p[@class='main-button'][text()='Delete']");
    private static final By BACK_BUTTON_LOCATOR = By.cssSelector(".subButton.bBack");

    public EditProfilePage checkUserIsOnEditProfilePage() {
        waitForPageToLoad();
        Pattern pattern = Pattern.compile(EMPLOYEE_PROFILE_PAGE_URL_PATTERN);
        Matcher matcher = pattern.matcher(getDriver().getCurrentUrl());
        assertTrue(matcher.find());
        return this;
    }

    public EditProfilePage checkEmployeeDataIsEquals(EmployeeData employeeData) {
        assertEquals(getEmployeeData(), employeeData);
        return this;
    }

    public EditProfilePage checkDeletePopUpTextByEmployeeData(EmployeeData employeeData) {
        String expectedText = String.format("Are you sure you want to delete %s %s?", employeeData.getFirstName(), employeeData.getLastName());
        assertEquals(getDriver().switchTo().alert().getText(), expectedText);
        return this;
    }

    public EditProfilePage clickDeleteButton() {
        getDeleteButton().click();
        return this;
    }

    public EditProfilePage clickUpdateButton() {
        getUpdateButton().click();
        return this;
    }

    public EditProfilePage clickBackButton() {
        getBackButton().click();
        return this;
    }

    public EditProfilePage declineDeleteConfirmation() {
        getDriver().switchTo().alert().dismiss();
        return this;
    }

    public EditProfilePage acceptDeleteConfirmation() {
        getDriver().switchTo().alert().accept();
        return this;
    }

    private WebElement getUpdateButton() {
        return getDriver().findElement(UPDATE_BUTTON_LOCATOR);
    }

    private WebElement getDeleteButton() {
        return getDriver().findElement(DELETE_BUTTON_LOCATOR);
    }

    private WebElement getBackButton() {
        return getDriver().findElement(BACK_BUTTON_LOCATOR);
    }
}
