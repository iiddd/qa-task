package base;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static base.DriverHolder.getDriver;

/**
 * This class is used to set before and after actions for all tests
 */

public class BaseTest {

    private static final String BASE_URL = "http://cafetownsend-angular-rails.herokuapp.com/";

    @BeforeClass
    public void beforeAnyTest() {
        DriverHolder.initDriver();
        openTestApp();
    }

    @AfterClass
    public void afterTest() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    private void openTestApp() {
        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        getDriver().get(BASE_URL);
    }
}
