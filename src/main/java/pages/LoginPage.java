package pages;

import base.BasePage;
import models.LoginModel;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

@UtilityClass
public class LoginPage extends BasePage {

    public static final String PATH_LOGIN = "/login";

    private static final By INPUT_USER_NAME = By.id("userName");
    private static final By INPUT_PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login");
    private static final By PROFILE_NAME = By.id("userName-value");

    public boolean isOnPage() {
        return isOnPage(PATH_LOGIN, INPUT_USER_NAME);
    }

    public static void signIn(LoginModel login) {
        sendKeys(INPUT_USER_NAME, login.getUserName());
        sendKeys(INPUT_PASSWORD, login.getPassword());
        click(LOGIN_BUTTON);
    }

    public static boolean isLoggedIn() {
        return isElementDisplayed(PROFILE_NAME);
    }
}
