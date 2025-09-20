package com.demoqa.pages.auth;

import com.demoqa.pages.*;
import lombok.experimental.*;
import org.openqa.selenium.*;

@UtilityClass
public class LoginPage extends BasePage {

    private final String PATH = "/login";
    private final By INPUT_USER_NAME = By.xpath("//input[@id='userName']");
    private final By INPUT_PASSWORD = By.xpath("//input[@id='password']");
    private final By LOGIN_BUTTON = By.xpath("//button[@id='login']");
    private final By VALIDATION_ERROR_MESSAGE = By.xpath("//p[@id='name']");

    public boolean isOnPage() {
        String expectedUrl = BASE_URL + PATH;
        waitForElementToBeVisible(INPUT_USER_NAME);
        String currentUrl = getCurrentUrl();
        return currentUrl.equals(expectedUrl);
    }

    public void enterLoginCredentials(String login, String password) {
        sendKeys(INPUT_USER_NAME, login);
        sendKeys(INPUT_PASSWORD, password);
        click(LOGIN_BUTTON);
    }

    public boolean isValidationErrorMessageDisplayed() {
        return isElementDisplayed(VALIDATION_ERROR_MESSAGE);
    }
}
