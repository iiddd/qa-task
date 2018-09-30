package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.EmployeeListFragment;
import Base.Fragments.LoginFragment;
import Base.Models.EmployeeData;
import Base.Models.EmployeeDataBuilder;
import Pages.EditProfilePage;
import Pages.EmployeeListPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testcase name: Employee. Create New Employee. Cancel
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Create new Employee
 * Step 1:
 * - Oped created employee profile
 * - Click "Delete" button
 * Expected result:
 * - Browser alert is displayed with text:
 * "Are you sure you want to delete FIRSTNAME LASTNAME?"
 * Step 2:
 * - Click "Cancel" button
 * Expected result:
 * - User is on Edit profile page
 * - User details are not changed
 * Step 3:
 * - Click "Delete" button
 * - Submit Delete Confirmation
 * Expected result:
 * - User is on Employee list page
 * - Employee successfully deleted. There is no such employee in the list
 */

public class EmployeeProfileDeleteEmployee extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EditProfilePage editProfilePage = new EditProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();
    private String FIRST_NAME = employeeData.getFirstName();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
        employeeListFragment.createEmployee(employeeData);
    }

    @Test
    public void test_011() {
        //step 1
        employeeListPage
                .openEmployeeProfileWithDoubleClickByPartialName(FIRST_NAME);
        editProfilePage
                .checkUserIsOnEditProfilePage()
                .clickDeleteButton()
                .checkDeletePopUpTextByEmployeeData(employeeData);
        //step 2
        editProfilePage
                .declineDeleteConfirmation()
                .checkFirstName(employeeData.getFirstName())
                .checkLastName(employeeData.getLastName())
                .checkStartDate(employeeData.getStartDate())
                .checkEmailAddress(employeeData.getEmail());
        //step 3
        editProfilePage
                .clickDeleteButton()
                .acceptDeleteConfirmation();
        employeeListPage
                .checkUserIsOnEmployeeListPage()
                .checkEmployeeIsAbsentInListByPartialName(FIRST_NAME);
    }
}
