package com.qa.functional.logout;

import base.BaseTest;
import base.fragments.LoginFragment;
import org.testng.annotations.*;
import pages.*;

/**
 * Testcase name: Logout. Employee page. Edit
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Navigate to Edit Employee page
 * Step 1:
 * - Click "Logout" button
 * Expected results:
 * - User is redirected to Login page
 * - Username and password fields are empty
 */

public class LogoutEditEmployee extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EditProfilePage editProfilePage = new EditProfilePage();
    private LoginPage loginPage = new LoginPage();
    private String PROFILE_NAME;

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
        PROFILE_NAME = employeeListPage
                .getRandomEmployeeListProfileName();
    }

    @Test
    public void test_019() {
        //step 1
        employeeListPage
                .selectEmployeeProfileByPartialName(PROFILE_NAME)
                .clickEditButton();
        editProfilePage
                .checkUserIsOnEditProfilePage();
        loginFragment
                .logout();
        loginPage
                .checkUserIsOnLoginPage()
                .checkUserNameFieldIsEmpty()
                .checkPasswordFieldIsEmpty();
    }
}
