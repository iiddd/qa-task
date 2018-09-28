package Pages;

import Base.BasePage;
import org.testng.Assert;

/**
 * This class is used to store all Employee list page methods
 */

public class EmployeeListPage extends BasePage {

    private static final String EMPLOYEE_LIST_PAGE_URL = "http://cafetownsend-angular-rails.herokuapp.com/employees";

    public EmployeeListPage checkUserIsOnEmployeeListPage() {
        waitForPageLoaded();
        Assert.assertEquals(driver.getCurrentUrl(), EMPLOYEE_LIST_PAGE_URL);
        return this;
    }
}
