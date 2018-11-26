package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.*;
import org.testng.annotations.*;
import pages.*;

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

public class OpenExistingEmployeeDetailsDoubleClick extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EditProfilePage editProfilePage = new EditProfilePage();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private String PROFILE_NAME;

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
        PROFILE_NAME = employeeListPage
                .getRandomEmployeeListProfileName();
    }

    @Test
    public void test_006() {
        //step 1
        openRandomProfile();
        editProfilePage
                .checkUserIsOnEditProfilePage()
                .checkFirstName(getRandomProfileFirstName())
                .checkLastName(getRandomProfileLastName());
    }

    private void openRandomProfile() {
        employeeListPage
                .openEmployeeProfileWithDoubleClickByPartialName(PROFILE_NAME);
    }

    private String getRandomProfileFirstName() {
        return employeeListFragment
                .getFirstNameByFullProfileName(PROFILE_NAME);
    }

    private String getRandomProfileLastName() {
        return employeeListFragment
                .getLastNameByFullProfileName(PROFILE_NAME);
    }
}
