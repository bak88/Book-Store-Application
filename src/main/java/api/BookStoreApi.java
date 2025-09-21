package api;

import io.restassured.RestAssured;
import models.BookModel;

import java.util.List;

public class BookStoreApi {

    private static final String BASE_URL = "https://demoqa.com/BookStore/v1";

    public static List<BookModel> getBooks() {
        return RestAssured
                .given()
                .when()
                .get(BASE_URL + "/Books")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("books", BookModel.class);
    }
}
