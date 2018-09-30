package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.EmployeeListFragment;
import Base.Fragments.LoginFragment;
import Base.Models.EmployeeData;
import Base.Models.EmployeeDataBuilder;
import Base.Utils.RandomUtils;
import Pages.CreateProfilePage;
import Pages.EmployeeListPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    private static final String RANDOM_FIRST_NAME = RandomUtils.getRandomAlphaNumeric(25);
    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
        employeeListPage.clickCreateButton();
    }

    @Test
    public void test_014() {
        //step 1
        createProfilePage
                .fillFirstNameField(RandomUtils.getRandomAlphaNumeric(2));
        createProfilePage
                .checkFirstNameFieldIsValid()
                .clearFirstNameField();
        //step 2
        createProfilePage
                .fillFirstNameField(RANDOM_FIRST_NAME);
        createProfilePage
                .checkFirstNameFieldIsValid();
        //step 3
        createProfilePage
                .fillLastNameField(RandomUtils.getRandomAlphaNumeric(2));
        createProfilePage
                .checkLastNameFieldIsValid()
                .clearLastNameField();
        //step 4
        createProfilePage
                .fillLastNameField(RandomUtils.getRandomAlphaNumeric(25));
        createProfilePage
                .checkLastNameFieldIsValid();
        //step 5
        createProfilePage
                .fillDateField(employeeData.getStartDate())
                .fillEmailField(employeeData.getEmail());
        createProfilePage
                .clickAddButton();
        employeeListPage
                .checkUserIsOnEmployeeListPage()
                .checkEmployeeIsInTheListByPartialName(RANDOM_FIRST_NAME);
    }

    @AfterMethod
    public void removeCreatedUser() {
        employeeListFragment.removeUserByPartialName(RANDOM_FIRST_NAME);
    }
}
