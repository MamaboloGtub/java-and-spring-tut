package com.mamabologtub.library_system.dtos.response;

import com.mamabologtub.library_system.entities.Book;

/**
 * @Author Tshepo M Mahudu on Jul 9, 2025.
 */

public record BooksResponse(Long id, String title, String author, String isbn, Boolean isAvailable) {
    public BooksResponse(Book book) {
        this(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.isIsavailable());
    }

}
