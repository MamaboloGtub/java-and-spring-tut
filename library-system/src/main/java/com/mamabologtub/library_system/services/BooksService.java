package com.mamabologtub.library_system.services;

import java.util.List;

import com.mamabologtub.library_system.dtos.BooksDto;
import com.mamabologtub.library_system.entities.Book;

/**
 * @Author Tshepo M Mahudu on Jul 9, 2025.
 */

public interface BooksService {

    Book createBook(BooksDto book);
    List<Book> getBooks();
    Book getBook(Long id);
    Book requestBook(Long id, boolean availability);
    Book toggleAvailable(Long id);

}
