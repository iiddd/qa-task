package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {

    private WebDriver driver;
    private static final String CHROMEDRIVER_PATH_PROPERTY = "webdriver.chrome.driver";
    private static final String GECKODRIVER_PATH_PROPERTY = "webdriver.gecko.driver";
    private static final String CHROMEDRIVER_MAC_PATH = "src/main/resources/drivers/mac/chromedriver";
    private static final String GECKODRIVER_MAC_PATH = "src/main/resources/drivers/mac/geckodriver";
    private static final String OS_NAME_PROPERTY = "os.name";
    private static final String MAC_OS_X_PLATFORM_NAME = "Mac OS X";
    private static final String BROWSER_PROPERTY = "browser";
    private static final String FF_DRIVER_PROPERTY = "gecko";
    private static final String CHROME_DRIVER_PROPERTY = "chrome";
    private static final String BASE_URL = "http://cafetownsend-angular-rails.herokuapp.com/";

    @BeforeClass
    public void beforeAnyTest() {
        openTestApp();
    }

    private void openTestApp() {
        getWebDriver().get(BASE_URL);
    }

    private WebDriver getWebDriver() {
        if (getProfileBrowserProperty().equals(CHROME_DRIVER_PROPERTY)) {
            if (isMac()) {
                System.setProperty(CHROMEDRIVER_PATH_PROPERTY, CHROMEDRIVER_MAC_PATH);
            }
            driver = new ChromeDriver();
            return driver;
        }
        if (getProfileBrowserProperty().equals(FF_DRIVER_PROPERTY)) {
            if (isMac()) {
                System.setProperty(GECKODRIVER_PATH_PROPERTY, GECKODRIVER_MAC_PATH);
            }
            driver = new FirefoxDriver();
            return driver;
        } else {
            //Chrome driver will be initialized as default webdriver in case profile is not selected
            if (isMac()) {
                System.setProperty(CHROMEDRIVER_PATH_PROPERTY, CHROMEDRIVER_MAC_PATH);
            }
            return new ChromeDriver();
        }
    }

    private String getProfileBrowserProperty() {
        return System.getProperty(BROWSER_PROPERTY);
    }

    private boolean isMac() {
        return System.getProperty(OS_NAME_PROPERTY).equals(MAC_OS_X_PLATFORM_NAME);
    }

    @AfterClass
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
