package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.EmployeeListFragment;
import Base.Fragments.LoginFragment;
import Pages.EmployeeListPage;
import Pages.EmployeeProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testcase name: Open existing employee details. Double click
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * Step 1:
 * Open Any Employee details using double click
 * Expected results:
 * - Employee details page is opened
 * - Employee first name and last name are the same as in the list
 */

public class EmployeeOpenExistingEmployeeDetailsDoubleClick extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EmployeeProfilePage employeeProfilePage = new EmployeeProfilePage();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private String RANDOM_EMPLOYEE_FULL_PROFILE_NAME;

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
        RANDOM_EMPLOYEE_FULL_PROFILE_NAME = employeeListPage.getRandomEmployeeListProfileName();
    }

    @Test
    public void test_006() {
        //step 1
        openRandomProfile();
        employeeProfilePage
                .checkUserIsOnEmployeeProfilePage()
                .checkFirstName(getRandomProfileFirstName())
                .checkLastName(getRandomProfileLastName());
    }

    private void openRandomProfile() {
        employeeListPage.openEmployeeProfileWithDoubleClickByPartialName(RANDOM_EMPLOYEE_FULL_PROFILE_NAME);
    }

    private String getRandomProfileFirstName() {
        return employeeListFragment.getFirstNameByFullProfileName(RANDOM_EMPLOYEE_FULL_PROFILE_NAME);
    }

    private String getRandomProfileLastName() {
        return employeeListFragment.getLastNameByFullProfileName(RANDOM_EMPLOYEE_FULL_PROFILE_NAME);
    }
}
