package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.LoginFragment;
import base.models.*;
import org.testng.annotations.*;
import pages.*;

/**
 * Testcase name: Employee. Create New Employee. Incomplete profile
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Click "Create" button
 * Step 1:
 * - Fill-in fields with correct data without email (First name, last name, start date)
 * - Check "Create" button is disabled
 * Expected results:
 * "Create" button is disabled
 * Step 2:
 * - Fill-in fields with correct data without start date (First name, last name, email)
 * - Check "Create" button is disabled
 * Expected results:
 * "Create" button is disabled
 * Step 2:
 * - Fill-in fields with correct data without first name (last name, email, start date)
 * - Check "Create" button is disabled
 * Expected results:
 * "Create" button is disabled
 * Step 3:
 * - Fill-in fields with correct data without last name (First name, start date, email)
 * - Check "Create" button is disabled
 * Expected results:
 * "Create" button is disabled
 */

public class CreateNewEmployeeIncompleteProfile extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private EmployeeData employeeData = new EmployeeDataBuilder().build();

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
        employeeListPage
                .clickCreateButton();
    }

    @Test
    public void test_014() {
        //step 1
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage()
                .fillFirstNameField(employeeData.getFirstName())
                .fillLastNameField(employeeData.getLastName())
                .fillDateField(employeeData.getStartDate())
                .checkAddButtonIsDisabled();
        //step 2
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage()
                .fillFirstNameField(employeeData.getFirstName())
                .fillLastNameField(employeeData.getLastName())
                .fillEmailField(employeeData.getEmail())
                .clearDateField()
                .checkAddButtonIsDisabled();
        //step 3
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage()
                .fillLastNameField(employeeData.getLastName())
                .fillEmailField(employeeData.getEmail())
                .fillDateField(employeeData.getStartDate())
                .clearFirstNameField()
                .checkAddButtonIsDisabled();
        //step 4
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage()
                .fillFirstNameField(employeeData.getFirstName())
                .fillEmailField(employeeData.getEmail())
                .fillDateField(employeeData.getStartDate())
                .clearLastNameField()
                .checkAddButtonIsDisabled();
    }
}
