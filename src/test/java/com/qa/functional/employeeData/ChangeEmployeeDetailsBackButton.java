package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.*;
import base.models.*;
import pages.*;
import org.testng.annotations.*;

/**
 * Testcase name: Employee. Change Employee details. Back
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Create new Employee
 * Step 1:
 * - Oped created employee profile
 * - Edit employee profile data
 * - Click "Back" button
 * Expected result:
 * - User is redirected to Employee list page
 * - There is a user with first created employee details in the list
 * - There is no user with updated details in the list
 */

public class ChangeEmployeeDetailsBackButton extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EditProfilePage editProfilePage = new EditProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();
    private EmployeeData updatedEmployeeData = new EmployeeDataBuilder().build();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
        employeeListFragment
                .createEmployee(employeeData);
    }

    @Test
    public void test_013() {
        //step 1
        employeeListPage
                .openEmployeeProfileWithDoubleClickByPartialName(employeeData.getFirstName());
        editProfilePage
                .fillFirstNameField(updatedEmployeeData.getFirstName())
                .fillLastNameField(updatedEmployeeData.getLastName())
                .fillDateField(updatedEmployeeData.getStartDate())
                .fillEmailField(updatedEmployeeData.getEmail());
        editProfilePage
                .clickBackButton();
        employeeListPage
                .checkUserIsOnEmployeeListPage()
                .checkEmployeeIsAbsentInListByPartialName(updatedEmployeeData.getFirstName())
                .checkEmployeeIsInTheListByPartialName(employeeData.getFirstName());
    }

    @AfterMethod
    public void removeCreatedUser() {
        employeeListFragment
                .removeUserByPartialName(employeeData.getFirstName());
    }
}
