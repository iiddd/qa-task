package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.*;
import base.models.*;
import base.utils.RandomUtils;
import org.testng.annotations.*;
import pages.*;

/**
 * Testcase name: Employee. Create New Employee. Format Restrictions. Names
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Click "Create" button
 * Step 1:
 * - Enter random alphanumeric string with length 2 symbols to First name field
 * - Check field validation state
 * Expected results:
 * Field is valid
 * Step 2:
 * - Enter random alphanumeric string with length 25 symbols to First name field
 * - Check field validation state
 * Expected results:
 * Field is valid
 * Step 3:
 * Enter random alphanumeric string with length 2 symbols to Last name field
 * - Check field validation state
 * Expected results:
 * Field is valid
 * Step 4:
 * - Enter random alphanumeric string with length 25 symbols to Last name field
 * - Check field validation state
 * Expected results:
 * Field is valid
 * Step 5:
 * - Fill in other user details
 * - Click "Add" button
 * Expected result:
 * - User is redirected to Employee List page
 * - There is a user with specified First and Last names
 */

public class CreateNewEmployeeFormatRestrictionNames extends BaseTest {

    private static final String FIRST_NAME = RandomUtils.getRandomAlphaNumeric(25);
    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
        employeeListPage
                .clickCreateButton();
    }

    @Test
    public void test_015() {
        //step 1
        createProfilePage
                .fillFirstNameField(RandomUtils.getRandomAlphaNumeric(2))
                .checkFirstNameFieldIsValid()
                .clearFirstNameField();
        //step 2
        createProfilePage
                .fillFirstNameField(FIRST_NAME)
                .checkFirstNameFieldIsValid();
        //step 3
        createProfilePage
                .fillLastNameField(RandomUtils.getRandomAlphaNumeric(2))
                .checkLastNameFieldIsValid()
                .clearLastNameField();
        //step 4
        createProfilePage
                .fillLastNameField(RandomUtils.getRandomAlphaNumeric(25))
                .checkLastNameFieldIsValid();
        //step 5
        createProfilePage
                .fillDateField(employeeData.getStartDate())
                .fillEmailField(employeeData.getEmail())
                .clickAddButton();
        employeeListPage
                .checkUserIsOnEmployeeListPage()
                .checkEmployeeIsInTheListByPartialName(FIRST_NAME);
    }

    @AfterMethod
    public void removeCreatedUser() {
        employeeListFragment
                .removeUserByPartialName(FIRST_NAME);
    }
}
