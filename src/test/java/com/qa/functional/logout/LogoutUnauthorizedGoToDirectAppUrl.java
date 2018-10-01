package com.qa.functional.logout;

import Base.BaseTest;
import Base.Fragments.LoginFragment;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.Constants.EMPLOYEE_LIST_PAGE_URL;

/**
 * Testcase name: Logout. Employee page. Edit
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
        loginFragment.logout();
        driver.get(EMPLOYEE_LIST_PAGE_URL);
        loginPage.checkUserIsOnLoginPage();
    }
}
