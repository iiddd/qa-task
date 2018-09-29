package com.qa.functional.employeeData;

import Base.BaseTest;
import Base.Fragments.LoginFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
 * - "Edit" button
 * - "Delete" button
 * - Employee list
 * - "Logout" button
 */

public class EmployeeListInitialState extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment.loginToApp();
    }

    @Test
    public void test_005() {
        System.out.print("123");
    }
}
