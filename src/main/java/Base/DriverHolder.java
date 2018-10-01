package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class is used to init and store Webdriver
 */

public class DriverHolder {

    private static final String CHROMEDRIVER_PATH_PROPERTY = "webdriver.chrome.driver";
    private static final String GECKODRIVER_PATH_PROPERTY = "webdriver.gecko.driver";
    private static final String CHROMEDRIVER_MAC_PATH = "src/main/resources/drivers/mac/chromedriver";
    private static final String GECKODRIVER_MAC_PATH = "src/main/resources/drivers/mac/geckodriver";
    private static final String OS_NAME_PROPERTY = "os.name";
    private static final String MAC_OS_X_PLATFORM_NAME = "Mac OS X";
    private static final String BROWSER_PROPERTY = "browser";
    private static final String FF_DRIVER_PROPERTY = "gecko";
    private static final String CHROME_DRIVER_PROPERTY = "chrome";
    public static WebDriver driver;

    public static WebDriver initDriver() {
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
        }
        //Chrome driver will be initialized as default webdriver in case profile is not selected
        if (isMac()) {
            System.setProperty(CHROMEDRIVER_PATH_PROPERTY, CHROMEDRIVER_MAC_PATH);
        }
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static String getProfileBrowserProperty() {
        return System.getProperty(BROWSER_PROPERTY);
    }

    private static boolean isMac() {
        return System.getProperty(OS_NAME_PROPERTY).equals(MAC_OS_X_PLATFORM_NAME);
    }
}
