package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.LoginFragment;
import Base.Models.EmployeeData;
import Base.Models.EmployeeDataBuilder;
import Pages.CreateProfilePage;
import Pages.EditProfilePage;
import Pages.EmployeeListPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.Constants.EMPTY_STRING;

/**
 * Testcase name: Employee. Create New Employee. Basic flow
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * Step 1:
 * Click "Create" button
 * Expected results:
 * - User is redirected to Employee Profile page
 * - Following elements are displayed on the page:
 * - "Logout" button
 * - "Cancel" button
 * - "First name" field empty by default
 * - "First Last" field empty by default
 * - "Start date" field empty by default
 * - "Email" field empty by default
 * - "Add" button disabled by default
 * Step 2:
 * Fill-in all fields with correct data (First name, last name, start date, email)
 * Expected results:
 * - All fields are validated correctly
 * - "Add" button becomes enabled
 * Step 3:
 * Click "Add" button
 * Expected reuslt:
 * - User is redirected to Employee list page
 * - Employee with defined First name and Last name is in the list
 * Step 4:
 * Open Created employee profile
 * Expected result:
 * - User is redirected to Employee profile page
 * - User data corresponds to just created employee
 */

public class CreateNewEmployeeBasicFlow extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private EditProfilePage editProfilePage = new EditProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
    }

    @Test
    public void test_008() {
        //step 1
        employeeListPage.clickCreateButton();
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage()
                .checkFirstNameFieldIsDisplayed()
                .checkFirstName(EMPTY_STRING)
                .checkLastNameFieldIsDisplayed()
                .checkLastName(EMPTY_STRING)
                .checkDateFieldIsDisplayed()
                .checkStartDate(EMPTY_STRING)
                .checkEmailFieldIsDisplayed()
                .checkEmailAddress(EMPTY_STRING)
                .checkLogoutButtonIsDisplayed();
        createProfilePage
                .checkAddButtonIsDisplayed()
                .checkCancelButtonIsDisplayed()
                .checkAddButtonIsDisabled();
        //step 2
        createProfilePage
                .fillFirstNameField(employeeData.getFirstName())
                .fillLastNameField(employeeData.getLastName())
                .fillDateField(employeeData.getStartDate())
                .fillEmailField(employeeData.getEmail())
                .checkAddButtonIsEnabled()
                .checkFirstNameFieldIsValid()
                .checkLastNameFieldIsValid()
                .checkDateFieldIsValid()
                .checkEmailFieldIsValid();
        //step 3
        createProfilePage.clickAddButton();
        employeeListPage
                .checkUserIsOnEmployeeListPage()
                .checkEmployeeIsInTheListByPartialName(employeeData.getFirstName());
        //step 4
        employeeListPage.openEmployeeProfileWithDoubleClickByPartialName(employeeData.getFirstName());
        editProfilePage
                .checkUserIsOnEmployeeProfilePage()
                .checkEmployeeDataIsEquals(employeeData);
    }
}
