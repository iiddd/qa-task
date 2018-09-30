package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * This class is used to get and keep driver and store methods, required for all pages
 */

public class BasePage {

    public static WebDriver driver;
    private static final int TIMEOUT_3_SEC = 3000;
    private static final int TIMEOUT_30_SECONDS = 30;
    private static final String CHROMEDRIVER_PATH_PROPERTY = "webdriver.chrome.driver";
    private static final String GECKODRIVER_PATH_PROPERTY = "webdriver.gecko.driver";
    private static final String CHROMEDRIVER_MAC_PATH = "src/main/resources/drivers/mac/chromedriver";
    private static final String GECKODRIVER_MAC_PATH = "src/main/resources/drivers/mac/geckodriver";
    private static final String OS_NAME_PROPERTY = "os.name";
    private static final String MAC_OS_X_PLATFORM_NAME = "Mac OS X";
    private static final String BROWSER_PROPERTY = "browser";
    private static final String FF_DRIVER_PROPERTY = "gecko";
    private static final String CHROME_DRIVER_PROPERTY = "chrome";

    public WebDriver getWebDriver() {
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
            driver = new ChromeDriver();
            return driver;
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(TIMEOUT_3_SEC);
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30_SECONDS);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    // this wait is needed in case it's uncomfortable to use conditions
    public void waitForSomeTime(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Throwable error) {
        }
    }

    private String getProfileBrowserProperty() {
        return System.getProperty(BROWSER_PROPERTY);
    }

    private boolean isMac() {
        return System.getProperty(OS_NAME_PROPERTY).equals(MAC_OS_X_PLATFORM_NAME);
    }
}
