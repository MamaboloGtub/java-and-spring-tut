package com.mamabologtub.library_system.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mamabologtub.library_system.dtos.BooksDto;
import com.mamabologtub.library_system.entities.Book;
import com.mamabologtub.library_system.exception.CustomException;
import com.mamabologtub.library_system.repositories.BooksRepository;
import com.mamabologtub.library_system.services.BooksService;

import jakarta.persistence.EntityNotFoundException;

/**
 * @Author Tshepo M Mahudu on Jul 9, 2025.
 */

@Service
public class BooksServiceImpl implements BooksService {


    private BooksRepository booksRepository;

    @Override
    public Book createBook(BooksDto bookdto) {
        String localIsbn = bookdto.getIsbn();
        Optional<Book> optionalBook = this.booksRepository.findByIsbn(localIsbn);
        if(optionalBook.isPresent()) {
            throw new CustomException("The ISBN already exists", HttpStatus.CONFLICT.value());
        }
        Book book = mapToDto(bookdto);
        Book savedBook = booksRepository.save(book);
        return savedBook;
    }

    @Override
    public List<Book> getBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = booksRepository.findById(id);
        if(book.isPresent()) {
            return book.get();
        }
        throw new EntityNotFoundException();

    }

    @Override
    public Book requestBook(Long id, boolean availability) {
        Optional<Book> book = booksRepository.findById(id);
        if(book.isPresent()) {
            Book requestedBook = book.get();
            requestedBook.setIsavailable(availability);
            return booksRepository.save(requestedBook);
        }
        throw new EntityNotFoundException();
    }

    @Override
    public Book toggleAvailable(Long id) {
        Book toggleBook = new Book();
        Book book = booksRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found: " + id));
        book.setIsavailable(book.isIsavailable() ? true : !book.isIsavailable());
        return booksRepository.save(book);
    }

    private Book mapToDto(BooksDto dto) {
        Book entity = new Book();
        entity.setAuthor(dto.getAuthor());
        entity.setField(dto.getCategoryName());
        entity.setIsbn(dto.getIsbn());
        entity.setTitle(dto.getTitle());
        entity.setPublisher(dto.getPublisher());
        entity.setIsavailable(true);
        return entity;
    }

    @Autowired
    public void setBooksRepository(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


}
