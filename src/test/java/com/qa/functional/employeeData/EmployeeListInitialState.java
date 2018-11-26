package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.LoginFragment;
import org.testng.annotations.*;
import pages.EmployeeListPage;

/**
 * Testcase name: Employee list. initial state
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * Step 1:
 * Check Employee list page initial state:
 * Expected results:
 * Following elements are displayed on the page:
 * - "Create" button
 * - "Edit" button (Disabled by default)
 * - "Delete" button (Disabled by default)
 * - Employee list
 * - "Logout" button
 */

public class EmployeeListInitialState extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
    }

    @Test
    public void test_005() {
        //step 1
        employeeListPage
                .checkCreateButtonIsDisplayed()
                .checkEditButtonIsDisplayed()
                .checkDeleteButtonIsDisplayed()
                .checkEmployeeListIsDisplayed()
                .checkLogoutButtonIsDisplayed()
                .checkEditButtonIsDisabled()
                .checkDeleteButtonIsDisabled();
    }
}
