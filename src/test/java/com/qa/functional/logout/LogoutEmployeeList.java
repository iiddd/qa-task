package com.qa.functional.logout;

import Base.BaseTest;
import Base.Fragments.LoginFragment;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testcase name: Logout. Employee page. Edit
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
        loginFragment.loginToApp();
    }

    @Test
    public void test_019() {
        //step 1
        loginFragment.logout();
        loginPage
                .checkUserIsOnLoginPage()
                .checkUserNameFieldIsEmpty()
                .checkPasswordFieldIsEmpty();
    }
}
