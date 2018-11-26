package com.qa.functional.logout;

import base.BaseTest;
import base.fragments.LoginFragment;
import org.testng.annotations.*;
import pages.LoginPage;

/**
 * Testcase name: Logout. Employee page. Employee List
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * Step 1:
 * - Click "Logout" button
 * Expected results:
 * - User is redirected to Login page
 * - Username and password fields are empty
 */

public class LogoutEmployeeList extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
    }

    @Test
    public void test_020() {
        //step 1
        loginFragment
                .logout();
        loginPage
                .checkUserIsOnLoginPage()
                .checkUserNameFieldIsEmpty()
                .checkPasswordFieldIsEmpty();
    }
}
