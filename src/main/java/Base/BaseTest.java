package Base;

import Pages.BasePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * This class is used to set before and after actions for all tests
 */

public class BaseTest extends BasePage {

    private static final String BASE_URL = "http://cafetownsend-angular-rails.herokuapp.com/";

    @BeforeClass
    public void beforeAnyTest() {
        openTestApp();
        waitForPageLoaded();
    }

    @AfterClass
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void openTestApp() {
        getWebDriver().get(BASE_URL);
    }
}
