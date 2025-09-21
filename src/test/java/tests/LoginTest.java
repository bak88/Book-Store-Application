package tests;

import base.*;
import lombok.extern.slf4j.*;
import models.*;
import pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class LoginTest {

    private LoginModel login;

    @BeforeEach
    void setUp() {
        BasePage.setDriver(new ChromeDriver());
        login = new LoginModel();
        login.setUserName("nintendo");
        login.setPassword("090290B@k");
    }
    @Test
    void testValidLogin() {
        BasePage.driver.get(BasePage.BASE_URL + LoginPage.PATH_LOGIN);
        assertTrue(LoginPage.isOnPage(), "Login page is not loaded");
        log.info("The Login page is open");

        LoginPage.signIn(login);
        assertTrue(LoginPage.isLoggedIn(), "Authorization failed");
        log.info("A successful login is checked");
    }

    @AfterEach
    void tearDown() {
        if (BasePage.driver != null) {
            BasePage.driver.quit();
        }
    }
}
