package pages;

import base.*;
import lombok.experimental.*;
import org.openqa.selenium.*;
import java.util.*;
import java.util.stream.*;

@UtilityClass
public class BooksPage extends BasePage {

    public static final String PATH = "/books";
    private static final By BOOK_TITLES = By.xpath("//div[@class='rt-tbody']//a");

    public static boolean isOnPage() {
        return isOnPage(PATH, BOOK_TITLES);
    }

    public static List<String> getBookTitles() {
        return driver.findElements(BOOK_TITLES)
                .stream()
                .map(WebElement::getText)
                .sorted()
                .toList();
    }
}
