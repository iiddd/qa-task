package Base.Fragments;

import Base.Models.EmployeeData;
import Pages.CreateProfilePage;
import Pages.EmployeeListPage;

/**
 * This class is used to store common methods for Employee list tests
 */

public class EmployeeListFragment {

    private static final String SPACE = " ";
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private CreateProfilePage createProfilePage = new CreateProfilePage();

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

    public String getFirstNameByFullProfileName(String fullProfileName) {
        return fullProfileName.split(SPACE)[0];
    }

    public String getLastNameByFullProfileName(String fullProfileName) {
        return fullProfileName.split(SPACE)[1];
    }
}
