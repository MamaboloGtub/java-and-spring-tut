package com.mamabologtub.library_system.dtos;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Jul 4, 2025.
 */

@Data
public class BooksDto {

    private Long id;
    private String title;
    private String author;

    private String isbn;

    @Column(name = "field")
    private String categoryName;

    private String publisher;

    @Column(name = "pubication_year")
    private String publicationYear;
    private boolean isAvailable;

}
