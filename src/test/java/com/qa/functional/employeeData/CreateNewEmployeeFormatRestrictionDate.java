package com.qa.functional.employeeData;

import base.BaseTest;
import base.fragments.LoginFragment;
import org.testng.annotations.*;
import pages.*;

/**
 * Testcase name: Employee. Create New Employee. Format Restrictions. Date
 * Preconditions:
 * - Open Test app in browser (http://cafetownsend-angular-rails.herokuapp.com/)
 * - Login to app as Luke Skywalker
 * - Click "Create" button
 * Step 1:
 * - Enter "2040-13-01" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 2:
 * - Enter "1950-00-14" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 3:
 * - Enter "2040-12-32" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 4:
 * - Enter "1950-01-00" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 5:
 * - Enter "204a-01-31" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 6:
 * - Enter "1950-0b-12" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 7:
 * - Enter "2018-01-0b" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 8:
 * - Enter "2019-02-13bc" to date name field
 * - Check field validation state
 * Expected results:
 * Field is invalid
 * Step 9:
 * - Enter "1950-01-31" to date name field
 * - Check field validation state
 * Expected results:
 * Field is valid
 * Step 10:
 * - Enter "2040-12-01" to date name field
 * - Check field validation state
 * Expected results:
 * Field is valid
 */

public class CreateNewEmployeeFormatRestrictionDate extends BaseTest {

    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private String INVALID_DATE_TO_TEST1 = "2040-13-01";
    private String INVALID_DATE_TO_TEST2 = "1950-00-14";
    private String INVALID_DATE_TO_TEST3 = "2040-12-32";
    private String INVALID_DATE_TO_TEST4 = "1950-01-00";
    private String INVALID_DATE_TO_TEST5 = "204a-01-31";
    private String INVALID_DATE_TO_TEST6 = "1950-0b-12";
    private String INVALID_DATE_TO_TEST7 = "2018-01-0b";
    private String INVALID_DATE_TO_TEST8 = "2019-02-13bc";
    private String VALID_DATE_TO_TEST1 = "1950-01-31";
    private String VALID_DATE_TO_TEST2 = "2040-12-01";

    @BeforeMethod
    public void beforeMethod() {
        loginFragment
                .loginToApp();
        employeeListPage
                .clickCreateButton();
    }

    @Test
    public void test_017() {
        //step 1
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST1)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 2
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST2)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 3
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST3)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 4
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST4)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 5
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST5)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 6
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST6)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 7
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST7)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 8
        createProfilePage
                .fillDateField(INVALID_DATE_TO_TEST8)
                .checkDateFieldIsInvalid()
                .clearDateField();
        //step 9
        createProfilePage
                .fillDateField(VALID_DATE_TO_TEST1)
                .checkDateFieldIsValid()
                .clearDateField();
        //step 10
        createProfilePage
                .fillDateField(VALID_DATE_TO_TEST2)
                .checkDateFieldIsValid()
                .clearDateField();
    }
}
