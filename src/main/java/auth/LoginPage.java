package auth;

import data.ScenarioData;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

@UtilityClass
public class LoginPage extends BasePage {

    public static final String PATH_LOGIN = "/login";

    private static final By INPUT_USER_NAME = By.id("userName");
    private static final By INPUT_PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login");

    public boolean isOnPage() {
        return isOnPage(PATH_LOGIN, INPUT_USER_NAME);
    }

    public static void enterLoginAndPassword(String login, String password) {
        sendKeys(INPUT_USER_NAME, login);
        sendKeys(INPUT_PASSWORD, password);
        click(LOGIN_BUTTON);
    }


    public static void signIn() {
        enterLoginAndPassword(
                ScenarioData.getInstance().getUserName(),
                ScenarioData.getInstance().getPassword()
        );
    }
}
