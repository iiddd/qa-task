package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private WebDriver driver;
    private static final String BROWSER_PROPERTY = "browser";
    private static final String FF_DRIVER_PROPERTY = "gecko";
    private static final String CHROME_DRIVER_PROPERTY = "chrome";
    private static final String BASE_URL = "http://cafetownsend-angular-rails.herokuapp.com/openTestApp";

    @BeforeClass
    public void beforeAnyTest() {
        openTestApp();
    }

    protected void openTestApp() {
        getWebDriver().get(BASE_URL);
    }

    private WebDriver getWebDriver() {
        if (getProfileBrowserProperty().equals(CHROME_DRIVER_PROPERTY)) {
            driver = new ChromeDriver();
            return driver;
        }
        if (getProfileBrowserProperty().equals(FF_DRIVER_PROPERTY)) {
            driver = new FirefoxDriver();
            return driver;
        } else {
            //Chrome driver will be initialized as default webdriver in case profile is not selected
            return new ChromeDriver();
        }
    }

    private String getProfileBrowserProperty() {
        return System.getProperty(BROWSER_PROPERTY);
    }

    @AfterClass
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
