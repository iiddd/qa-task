package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.LoginFragment;
import base.models.*;
import org.testng.annotations.*;
import pages.*;

/**
 * Testcase name: Employee. Create New Employee. Cancel
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * Step 1:
 * - Click "Create" button
 * - Fill-in all fields with correct data (First name, last name, start date, email)
 * - Click "Cancel" button
 * Expected results:
 * - User is redirected to Employee list page
 * - There is no employee with such first name/last name in the list
 */

public class CreateNewEmployeeCancel extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
    }

    @Test
    public void test_009() {
        //step 1
        employeeListPage
                .clickCreateButton();
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage()
                .fillFirstNameField(employeeData.getFirstName())
                .fillLastNameField(employeeData.getLastName())
                .fillDateField(employeeData.getStartDate())
                .fillEmailField(employeeData.getEmail())
                .clickCancelButton();
        employeeListPage
                .checkUserIsOnEmployeeListPage()
                .checkEmployeeIsAbsentInListByPartialName(employeeData.getFirstName());
    }
}
