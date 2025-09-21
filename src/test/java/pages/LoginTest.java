package pages;

import data.AuthData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @BeforeEach
    void setUp() {
        BasePage.setDriver(new ChromeDriver());
        AuthData.getInstance().setUserName("nintendo");
        AuthData.getInstance().setPassword("090290B@k");
    }

    @Test
    void testValidLogin() {
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
        AuthData.getInstance().clear();
    }
}
