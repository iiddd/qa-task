package com.qa.functional.login;

import base.BaseTest;
import pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Testcase name: Login. Incorrect Login
 * Preconditions:
 * Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * Step 1:
 * - Enter incorrect login and correct password
 * - Click "Submit" button
 * Expected results:
 * Error message with following text is displayed "Invalid username or password!"
 */

public class IncorrectLogin extends BaseTest {

    private static final String LOGIN = "Luke1";
    private static final String PASSWORD = "Skywalker";
    private LoginPage loginPage = new LoginPage();

    @Test
    public void test_003() {
        //step 1
        loginPage
                .inputLoginName(LOGIN)
                .inputPassword(PASSWORD)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed()
                .checkErrorMessageText();
    }
}