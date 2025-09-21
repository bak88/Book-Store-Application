package data;

import lombok.*;
import java.time.*;

@Data
public class Book {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private LocalDateTime publishDate;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}