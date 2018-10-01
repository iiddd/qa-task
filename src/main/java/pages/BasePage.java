package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import static base.DriverHolder.getDriver;

/**
 * This class is used to store methods, required for all pages
 */

public class BasePage {

    private static final int TIMEOUT_3_SEC = 3000;
    private static final int TIMEOUT_30_SECONDS = 30;

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) getDriver())
                .executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(TIMEOUT_3_SEC);
            WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_30_SECONDS);
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

    public void navigateTo(String url) {
        getDriver().get(url);
    }
}
