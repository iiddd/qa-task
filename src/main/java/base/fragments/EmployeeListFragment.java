package base.fragments;

import base.models.EmployeeData;
import pages.*;

import static base.Constants.EMPLOYEE_LIST_PAGE_URL;
import static base.DriverHolder.getDriver;

/**
 * This class is used to store common methods for Employee list tests
 */

public class EmployeeListFragment {

    private static final String SPACE = " ";
    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private EditProfilePage editProfilePage = new EditProfilePage();

    public void createEmployee(EmployeeData employeeData) {
        employeeListPage
                .clickCreateButton();
        createProfilePage
                .checkUserIsOnCreateEmployeeProfilePage()
                .fillFirstNameField(employeeData.getFirstName())
                .fillLastNameField(employeeData.getLastName())
                .fillDateField(employeeData.getStartDate())
                .fillEmailField(employeeData.getEmail());
        createProfilePage
                .clickAddButton();
    }

    public void removeUserByPartialName(String name) {
        navigateToEmployeeListPage();
        employeeListPage
                .waitForPageToLoad();
        employeeListPage
                .openEmployeeProfileWithDoubleClickByPartialName(name);
        editProfilePage
                .checkUserIsOnEditProfilePage()
                .clickDeleteButton()
                .acceptDeleteConfirmation();
    }

    public String getFirstNameByFullProfileName(String fullProfileName) {
        return fullProfileName.split(SPACE)[0];
    }

    public String getLastNameByFullProfileName(String fullProfileName) {
        return fullProfileName.split(SPACE)[1];
    }

    private void navigateToEmployeeListPage() {
        getDriver().get(EMPLOYEE_LIST_PAGE_URL);
//        waitForPageToLoad();
        loginFragment.loginToApp();
    }
}
