package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Base.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * This page is used to store all Employee profile page methods
 */

public class CreateProfilePage extends BaseProfilePage {

    private static final String CREATE_EMPLOYEE_PROFILE_PAGE_URL = "http://cafetownsend-angular-rails.herokuapp.com/employees/new";
    private static final By CANCEL_BUTTON_LOCATOR = By.cssSelector(".subButton.bCancel");
    private static final By ADD_BUTTON_LOCATOR = By.xpath("//button[@class='main-button'][text()='Add']");

    public CreateProfilePage checkUserIsOnCreateEmployeeProfilePage() {
        waitForPageLoaded();
        assertEquals(driver.getCurrentUrl(), CREATE_EMPLOYEE_PROFILE_PAGE_URL);
        return this;
    }

    public CreateProfilePage checkCancelButtonIsDisplayed() {
        assertTrue(getCancelButton().isDisplayed());
        return this;
    }

    public CreateProfilePage checkAddButtonIsDisplayed() {
        assertTrue(getAddButton().isDisplayed());
        return this;
    }

    public CreateProfilePage checkAddButtonIsDisabled() {
        assertTrue(Boolean.valueOf(getAddButton().getAttribute(ATTR_DISABLED)));
        return this;
    }

    public CreateProfilePage checkAddButtonIsEnabled() {
        waitForPageLoaded();
        assertFalse(Boolean.valueOf(getAddButton().getAttribute(ATTR_DISABLED)));
        return this;
    }

    public CreateProfilePage checkFirstNameFieldIsValid() {
        assertTrue(getFirstNameField().getAttribute(ATTR_CLASS).contains(IS_VALID_PARTIAL_CLASSNAME));
        return this;
    }

    public CreateProfilePage checkLastNameFieldIsValid() {
        assertTrue(getLastNameField().getAttribute(ATTR_CLASS).contains(IS_VALID_PARTIAL_CLASSNAME));
        return this;
    }

    public CreateProfilePage checkDateFieldIsValid() {
        assertTrue(getDateField().getAttribute(ATTR_CLASS).contains(IS_VALID_PARTIAL_CLASSNAME));
        return this;
    }

    public CreateProfilePage checkEmailFieldIsValid() {
        assertTrue(getEmailField().getAttribute(ATTR_CLASS).contains(IS_VALID_PARTIAL_CLASSNAME));
        return this;
    }

    public CreateProfilePage clickAddButton() {
        getAddButton().click();
        return this;
    }

    public CreateProfilePage fillFirstNameField(String firstName) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
        return this;
    }

    public CreateProfilePage fillLastNameField(String firstName) {
        getLastNameField().clear();
        getLastNameField().sendKeys(firstName);
        return this;
    }

    public CreateProfilePage fillDateField(String firstName) {
        getDateField().clear();
        getDateField().sendKeys(firstName);
        return this;
    }

    public CreateProfilePage fillEmailField(String firstName) {
        getEmailField().clear();
        getEmailField().sendKeys(firstName);
        return this;
    }

    private WebElement getCancelButton() {
        return driver.findElement(CANCEL_BUTTON_LOCATOR);
    }

    private WebElement getAddButton() {
        return driver.findElement(ADD_BUTTON_LOCATOR);
    }
}
