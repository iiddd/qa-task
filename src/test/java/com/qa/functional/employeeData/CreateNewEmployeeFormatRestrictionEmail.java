package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.LoginFragment;
import base.utils.RandomUtils;
import org.testng.annotations.*;
import pages.*;

/**
 * Testcase name: Employee. Create New Employee. Format Restrictions. Emails
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Click "Create" button
 * Step 1:
 * - Enter random alphanumeric string with length 3 symbols to Email field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 2:
 * - Enter random alphanumeric string + @ to email field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 3:
 * Enter random alphanumeric string + @ + random alphanumeric string to email field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 4:
 * - Enter random alphanumeric string + @ + random alphanumeric string + "." to email field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 5:
 * - Enter @ + random alphanumeric string + "." to email field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 5:
 * - Enter @ + random alphanumeric string + "." + alphanumeric to email field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 */

public class CreateNewEmployeeFormatRestrictionEmail extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
        employeeListPage
                .clickCreateButton();
    }

    @Test
    public void test_016() {
        //step 1
        createProfilePage
                .fillEmailField(getRandomAlphaNumeric())
                .checkEmailFieldIsInvalid()
                .clearEmailField();
        //step 2
        createProfilePage
                .fillEmailField(getRandomAlphaNumeric() + "@")
                .checkEmailFieldIsInvalid()
                .clearEmailField();
        //step 3
        createProfilePage
                .fillEmailField(getRandomAlphaNumeric() + "@" + getRandomAlphaNumeric())
                .checkEmailFieldIsInvalid()
                .clearEmailField();
        //step 4
        createProfilePage
                .fillEmailField(getRandomAlphaNumeric() + "@" + getRandomAlphaNumeric() + ".")
                .checkEmailFieldIsInvalid()
                .clearEmailField();
        //step 5
        createProfilePage
                .fillEmailField("@" + getRandomAlphaNumeric() + ".")
                .checkEmailFieldIsInvalid()
                .clearEmailField();
        //step 6
        createProfilePage
                .fillEmailField("@" + getRandomAlphaNumeric() + "." + getRandomAlphaNumeric())
                .checkEmailFieldIsInvalid()
                .clearEmailField();
    }

    private String getRandomAlphaNumeric() {
        return RandomUtils.getRandomAlphaNumeric(3);
    }
}
