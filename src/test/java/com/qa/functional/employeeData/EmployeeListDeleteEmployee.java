package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.EmployeeListFragment;
import Base.Fragments.LoginFragment;
import Base.Models.EmployeeData;
import Base.Models.EmployeeDataBuilder;
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
 * - Select created employee
 * Expected result:
 * - Click "Delete" button
 * Expected results:
 * Browser alert is displayed with text:
 * "Are you sure you want to delete FIRSTNAME LASTNAME?"
 * Step 2:
 * Click "Cancel" button in browser pop-up
 * Expected result:
 * Employee is not removed
 * Step 3:
 * - Click "Delete" button
 * - Click "OK" button
 * Expected result:
 * Employee successfully deleted. There is no such employee in the list
 */

public class EmployeeListDeleteEmployee extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();
    private String FIRST_NAME = employeeData.getFirstName();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
        employeeListFragment.createEmployee(employeeData);
    }

    @Test
    public void test_010() {
        //step 1
        employeeListPage
                .selectEmployeeProfileByPartialName(FIRST_NAME)
                .clickDeleteButton()
                .checkDeletePopUpTextByEmployeeData(employeeData);
        //step 2
        employeeListPage
                .declineDeleteConfirmation()
                .checkEmployeeIsInTheListByPartialName(FIRST_NAME);
        //step 3
        employeeListPage
                .clickDeleteButton()
                .acceptDeleteConfirmation()
                .checkEmployeeIsAbsentInListByPartialName(FIRST_NAME);
    }
}
