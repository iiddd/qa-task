package com.qa.functional.login;

import Base.BaseTest;
import Pages.EmployeeListPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static Base.Fragments.LoginFragment.LOGIN;
import static Base.Fragments.LoginFragment.PASSWORD;

/**
 * Testcase name: Login. Basic flow
 * Preconditions:
 * Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * Step 1:
 * Enter correct login and password
 * Expected results:
 * Fields marked as valid
 * Step 2:
 * Click "Login" button
 * Expected result:
 * User is redirected to Employee list page
 */

public class LoginTestBasicFlow extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private EmployeeListPage employeeListPage = new EmployeeListPage();

    @Test
    public void test_002() {
        //step 1
        loginPage
                .inputLoginName(LOGIN)
                .inputPassword(PASSWORD)
                .checkUserNameFieldIsValid()
                .checkPasswordFieldIsValid();
        //step 2
        loginPage.clickLoginButton();
        employeeListPage.checkUserIsOnEmployeeListPage();
    }
}
