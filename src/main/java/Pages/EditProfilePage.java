package Pages;

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

public class EditProfilePage extends BaseProfilePage {


    private static final String EMPLOYEE_PROFILE_PAGE_URL_PATTERN = "(http://cafetownsend-angular-rails.herokuapp.com/employees/)+([0-9]+)+/edit";
    private static final By UPDATE_BUTTON_LOCATOR = By.xpath("//button[@class='main-button']");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//p[@class='main-button'][text()='Delete']");

    public EditProfilePage checkUserIsOnEmployeeProfilePage() {
        waitForPageLoaded();
        Pattern pattern = Pattern.compile(EMPLOYEE_PROFILE_PAGE_URL_PATTERN);
        Matcher matcher = pattern.matcher(driver.getCurrentUrl());
        assertTrue(matcher.find());
        return this;
    }

    public EditProfilePage checkEmployeeDataIsEquals(EmployeeData employeeData) {
        assertEquals(getEmployeeData(), employeeData);
        return this;
    }

    private WebElement getUpdateButton() {
        return driver.findElement(UPDATE_BUTTON_LOCATOR);
    }

    private WebElement getDeleteButton() {
        return driver.findElement(DELETE_BUTTON_LOCATOR);
    }
}
