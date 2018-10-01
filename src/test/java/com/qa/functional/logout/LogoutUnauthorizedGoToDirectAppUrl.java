package com.qa.functional.logout;

import base.BaseTest;
import base.fragments.LoginFragment;
import pages.LoginPage;
import org.testng.annotations.*;

import static base.Constants.EMPLOYEE_LIST_PAGE_URL;

/**
 * Testcase name: Logout. Navigate to app direct url unauthorized
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * Step 1:
 * - Click "Logout" button
 * - Navigate to Employee list page direct url
 * Expected result:
 * User is redirected to login page
 */

public class LogoutUnauthorizedGoToDirectAppUrl extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
    }

    @Test
    public void test_021() {
        //step 1
        loginFragment
                .logout();
        loginPage
                .navigateTo(EMPLOYEE_LIST_PAGE_URL);
        loginPage
                .checkUserIsOnLoginPage();
    }
}
