package com.demoqa.pages;

import lombok.extern.slf4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.*;

@Slf4j
public class BasePage {

    public static final String BASE_URL = "https://demoqa.com";
    public static WebDriver driver;
    protected static WebDriverWait wait;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log.info("WebDriver установлен: {}", driver);
    }

    public static String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        log.debug("Текущий URL: {}", url);
        return url;
    }

    public static void sendKeys(By locator, String value) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            element.sendKeys(value);
            log.info("Ввод значения '{}' в элемент: {}", value, locator);
        } catch (TimeoutException | NoSuchElementException e) {
            log.error("Не удалось найти элемент для sendKeys: {} — {}", locator, e.getMessage());
        }
    }

    public static void click(By locator) {
        try {
            WebElement element = waitForElementToBeClickable(locator);
            element.click();
            log.info("Клик по элементу: {}", locator);
        } catch (TimeoutException | NoSuchElementException e) {
            log.error("Не удалось найти элемент для клика: {} — {}", locator, e.getMessage());
        }
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            boolean displayed = element.isDisplayed();
            log.debug("Элемент {} отображается: {}", locator, displayed);
            return displayed;
        } catch (TimeoutException e) {
            log.warn("Элемент {} не найден для отображения: {}", locator, e.getMessage());
            return false;
        }
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        log.debug("Ожидание видимости элемента: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        log.debug("Ожидание кликабельности элемента: {}", locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean isOnPage(String relativePath, By mainElement) {
        String expectedUrl = BASE_URL + relativePath;
        waitForElementToBeVisible(mainElement);
        boolean match = getCurrentUrl().equals(expectedUrl);
        log.info("Проверка URL: ожидаемый {}, фактический {}, совпадает: {}", expectedUrl, getCurrentUrl(), match);
        return match;
    }
}
