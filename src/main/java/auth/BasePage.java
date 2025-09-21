package auth;

import lombok.extern.slf4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

@Slf4j
public class BasePage {

    public static final String BASE_URL = "https://demoqa.com";
    public static WebDriver driver;
    protected static WebDriverWait wait;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log.info("Webdriver installed: {}", driver);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void sendKeys(By locator, String value) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(value);
            log.info("Entering the values '{}' into the element: {}", value, locator);
        } catch (Exception e) {
            log.error("Error when entering the text in {}: {}", locator, e.getMessage());
        }
    }

    public static void click(By locator) {
        try {
            WebElement element = waitForElementToBeClickable(locator);
            element.click();
            log.info("Click on the element: {}", locator);
        } catch (Exception e) {
            log.error("Error when clicking on {}: {}", locator, e.getMessage());
        }
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            log.warn("Element {} is not found: {}", locator, e.getMessage());
            return false;
        }
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean isOnPage(String relativePath, By mainElement) {
        String expectedUrl = BASE_URL + relativePath;
        waitForElementToBeVisible(mainElement);
        return getCurrentUrl().equals(expectedUrl);
    }
}
