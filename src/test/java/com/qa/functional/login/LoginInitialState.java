package com.qa.functional.login;

import base.BaseTest;
import pages.LoginPage;
import org.testng.annotations.*;

/**
 * Testcase name: Login. Initial state
 * Preconditions:
 * Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * Step 1:
 * Check elements on the page
 * Expected results:
 * Following elements should be displayed on the page:
 * - Login field
 * - Password field
 * - "Login" button
 * Step 2:
 * Check that "Login" button is disabled by default
 * Expected result:
 * "Login" button is disabled
 */

public class LoginInitialState extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void preconditions() {
        loginPage.waitForPageToLoad();
    }

    @Test
    public void test_001() {
        //step 1
        loginPage
                .checkLoginFieldIsDisplayed()
                .checkPasswordFieldIsDisplayed()
                .checkLoginButtonIsDisplayed();
        //step 2
        loginPage
                .checkLoginButtonIsDisabled();
    }
}
