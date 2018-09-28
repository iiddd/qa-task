package com.qa.functional.login;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Testcase name: Login. Basic flow
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

public class LoginTestInitialState extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @Test
    public void test_001() {
        //step 1
        loginPage.checkLoginFieldIsDisplayed()
                .checkPasswordFieldIsDisplayed()
                .checkLoginButtonIsDisplayed();
        //step 2
        loginPage.checkLoginButtonIsDisabled();
    }
}