package Base.Fragments;

/**
 * This class is used to store common methods for Employee list tests
 */

public class EmployeeListFragment {

    private static final String SPACE = " ";

    public void createEmployee() {
    }

    public String getFirstNameByFullProfileName(String fullProfileName) {
        return fullProfileName.split(SPACE)[0];
    }

    public String getLastNameByFullProfileName(String fullProfileName) {
        return fullProfileName.split(SPACE)[1];
    }
}
