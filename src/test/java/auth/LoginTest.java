package auth;

import data.ScenarioData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @BeforeEach
    void setUp() {
        BasePage.setDriver(new ChromeDriver());
        ScenarioData.getInstance().setUserName("nintendo");
        ScenarioData.getInstance().setPassword("090290B@k");
    }

    @Test
    void shouldLoginSuccessfully() {
        BasePage.driver.get(BasePage.BASE_URL + LoginPage.PATH_LOGIN);
        assertTrue(LoginPage.isOnPage(), "Login page is not loaded");
        LoginPage.signIn();
        boolean isLoggedIn = BasePage.isElementDisplayed(By.id("userName-value"));
        assertTrue(isLoggedIn, "Authorization failed - the profile is not displayed");
    }

    @AfterEach
    void tearDown() {
        if (BasePage.driver != null) {
            BasePage.driver.quit();
        }
        ScenarioData.getInstance().clear();
    }
}
