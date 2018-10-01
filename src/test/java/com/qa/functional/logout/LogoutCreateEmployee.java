package com.qa.functional.logout;

import Base.BaseTest;
import Base.Fragments.LoginFragment;
import Pages.*;
import org.testng.annotations.*;

/**
 * Testcase name: Logout. Employee page. Create
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Navigate to Create Employee page
 * Step 1:
 * - Click "Logout" button
 * Expected results:
 * - User is redirected to Login page
 * - Username and password fields are empty
 */

public class LogoutCreateEmployee extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
    }

    @Test
    public void test_018() {
        //step 1
        employeeListPage
                .clickCreateButton();
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage();
        loginFragment
                .logout();
        loginPage
                .checkUserIsOnLoginPage()
                .checkUserNameFieldIsEmpty()
                .checkPasswordFieldIsEmpty();
    }
}
