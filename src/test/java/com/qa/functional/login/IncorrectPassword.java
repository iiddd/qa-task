package com.qa.functional.login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Testcase name: Login. Incorrect Password
 * Preconditions:
 * Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * Step 1:
 * - Enter correct login and incorrect password
 * - Click "Submit" button
 * Expected results:
 * Error message with following text is displayed "Invalid username or password!"
 */

public class IncorrectPassword extends BaseTest {

    private static final String LOGIN = "Luke";
    private static final String PASSWORD = "Skywalker1";
    private LoginPage loginPage = new LoginPage();

    @Test
    public void test_004() {
        //step 1
        loginPage
                .inputLoginName(LOGIN)
                .inputPassword(PASSWORD)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed()
                .checkErrorMessageText();
    }
}