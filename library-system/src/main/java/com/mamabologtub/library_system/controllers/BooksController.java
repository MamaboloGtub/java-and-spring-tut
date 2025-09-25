package com.mamabologtub.library_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamabologtub.library_system.dtos.BooksDto;
import com.mamabologtub.library_system.entities.Book;
import com.mamabologtub.library_system.services.BooksService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @Author Tshepo M Mahudu on Jul 10, 2025.
 */

@RestController
@RequestMapping("/api/v2")
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/books")
    @Operation(summary = "", description = "")
    public List<Book> getAllBooks(){
        return booksService.getBooks();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(
            @RequestBody BooksDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(booksService.createBook(dto));
    }

    @GetMapping("/books/id")
    public Book getABook(Long id) {
        return booksService.getBook(id);
    }

    @PutMapping("/books/request/id")
    public Book toggleAvailable(@RequestBody Long id, Boolean avalilability) {
        return booksService.requestBook(id, avalilability);

    }

}
