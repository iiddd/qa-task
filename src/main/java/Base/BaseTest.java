package Base;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * This class is used to set before and after actions for all tests
 */

public class BaseTest extends BasePage {

    private static final String BASE_URL = "http://cafetownsend-angular-rails.herokuapp.com/";

    @BeforeClass
    public void beforeAnyTest() {
        openTestApp();
        waitForPageToLoad();
    }

    @AfterClass
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void openTestApp() {
        WebDriver driver = getWebDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }
}
