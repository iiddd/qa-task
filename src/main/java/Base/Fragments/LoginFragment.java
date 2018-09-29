package Base.Fragments;

import Pages.EmployeeListPage;
import Pages.LoginPage;

/**
 * This class is used to reuse login process methods in all tests, where it is a precondition.
 */

public class LoginFragment {

    private LoginPage loginPage = new LoginPage();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    public static final String LOGIN = "Luke";
    public static final String PASSWORD = "Skywalker";

    public void loginToApp() {
        loginPage.inputLoginName(LOGIN)
                .inputPassword(PASSWORD)
                .clickLoginButton();
        employeeListPage.checkUserIsOnEmployeeListPage();
    }
}
