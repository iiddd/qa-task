package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.EmployeeListFragment;
import Base.Fragments.LoginFragment;
import Base.Models.EmployeeData;
import Base.Models.EmployeeDataBuilder;
import Pages.EditProfilePage;
import Pages.EmployeeListPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testcase name: Employee. Change Employee details
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Create new Employee
 * Step 1:
 * - Oped created employee profile
 * - Edit employee profile data
 * - Click "Update" button
 * Expected result:
 * - User is redirected to Employee list page
 * - There is no user with first created employee details in the list
 * - There is a user with updated details in the list
 */

public class ChangeEmployeeDetailsBasicFlow extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EditProfilePage editProfilePage = new EditProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();
    private EmployeeData updatedEmployeeData = new EmployeeDataBuilder().build();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
        employeeListFragment.createEmployee(employeeData);
    }

    @Test
    public void test_012() {
        //step 1
        employeeListPage
                .openEmployeeProfileWithDoubleClickByPartialName(employeeData.getFirstName());
        editProfilePage
                .fillFirstNameField(updatedEmployeeData.getFirstName())
                .fillLastNameField(updatedEmployeeData.getLastName())
                .fillDateField(updatedEmployeeData.getStartDate())
                .fillEmailField(updatedEmployeeData.getEmail());
        editProfilePage
                .clickUpdateButton();
        employeeListPage
                .checkUserIsOnEmployeeListPage()
                .checkEmployeeIsAbsentInListByPartialName(employeeData.getFirstName())
                .checkEmployeeIsInTheListByPartialName(updatedEmployeeData.getFirstName());
    }

    @AfterMethod
    public void removeCreatedUser() {
        employeeListFragment.removeUserByPartialName(employeeData.getFirstName());
    }
}
