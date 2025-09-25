package com.mamabologtub.library_system.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamabologtub.library_system.entities.Book;


/**
 * @Author Tshepo M Mahudu on Jul 9, 2025.
 */

public interface BooksRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findByIsavailable(boolean isavailable);

}
