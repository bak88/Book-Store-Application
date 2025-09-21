package tests;

import base.*;
import api.*;
import models.*;
import pages.*;
import lombok.extern.slf4j.*;
import java.util.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class BooksTest {

    @BeforeEach
    void setUp() {
        BasePage.setDriver(new ChromeDriver());
    }
    @Test
    void booksMatchApi() {

        BasePage.driver.get(BasePage.BASE_URL + BooksPage.PATH);
        assertTrue(BooksPage.isOnPage(), "Book Store page is not loaded");
        log.info("Book Store page opened");

        List<String> uiBooks = BooksPage.getBookTitles();
        log.info("Books from UI: {}", uiBooks);

        List<BookModel> apiBooks = BookStoreApi.getBooks();
        List<String> apiTitles = apiBooks.stream()
                .map(BookModel::getTitle)
                .sorted()
                .toList();
        log.info("Books from API: {}", apiTitles);

        assertEquals(apiTitles, uiBooks, "UI and API books differ");
        log.info("Lists of books coincide");
    }

    @AfterEach
    void tearDown() {
        if (BasePage.driver != null) {
            BasePage.driver.quit();
        }
    }
}
