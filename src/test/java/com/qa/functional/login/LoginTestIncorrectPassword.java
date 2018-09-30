package com.qa.functional.login;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

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

public class LoginTestIncorrectPassword extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private static final String LOGIN = "Luke";
    private static final String PASSWORD = "Skywalker1";

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