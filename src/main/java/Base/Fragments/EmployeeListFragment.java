package Base.Fragments;

import Base.Models.EmployeeData;
import Pages.BasePage;
import Pages.CreateProfilePage;
import Pages.EditProfilePage;
import Pages.EmployeeListPage;

import static Base.Constants.EMPLOYEE_LIST_PAGE_URL;

/**
 * This class is used to store common methods for Employee list tests
 */

public class EmployeeListFragment extends BasePage {

    private static final String SPACE = " ";
    private LoginFragment loginFragment = new LoginFragment();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();
    private EditProfilePage editProfilePage = new EditProfilePage();

    public void createEmployee(EmployeeData employeeData) {
        employeeListPage.clickCreateButton();
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
        waitForPageToLoad();
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
        driver.get(EMPLOYEE_LIST_PAGE_URL);
        waitForPageToLoad();
        loginFragment.loginToApp();
    }
}
