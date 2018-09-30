package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.EmployeeListFragment;
import Base.Fragments.LoginFragment;
import Pages.EditProfilePage;
import Pages.EmployeeListPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testcase name: Employee. Open existing employee details. Edit Button
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * Step 1:
 * Select random employee details
 * Expected results:
 * - "Edit" button becomes enabled
 * - "Delete" button becomes enabled
 * Step 2:
 * Click "Edit" button
 * Expected results:
 * - Employee details page is opened
 * - Employee first name and last name are the same as in the list
 */

public class OpenExistingEmployeeDetailsEditButton extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EditProfilePage editProfilePage = new EditProfilePage();
    private EmployeeListFragment employeeListFragment = new EmployeeListFragment();
    private String PROFILE_NAME;

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
        PROFILE_NAME = employeeListPage.getRandomEmployeeListProfileName();
    }

    @Test
    public void test_007() {
        //step 1
        selectRandomProfile();
        employeeListPage
                .checkDeleteButtonIsEnabled()
                .checkEditButtonIsEnabled();
        //step 2
        employeeListPage
                .clickEditButton();
        editProfilePage
                .checkUserIsOnEditProfilePage()
                .checkFirstName(getRandomProfileFirstName())
                .checkLastName(getRandomProfileLastName());
    }

    private void selectRandomProfile() {
        employeeListPage.selectEmployeeProfileByPartialName(PROFILE_NAME);
    }

    private String getRandomProfileFirstName() {
        return employeeListFragment.getFirstNameByFullProfileName(PROFILE_NAME);
    }

    private String getRandomProfileLastName() {
        return employeeListFragment.getLastNameByFullProfileName(PROFILE_NAME);
    }
}
