package com.mamabologtub.library_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamabologtub.library_system.dtos.BookRequestDto;
import com.mamabologtub.library_system.entities.BookRequest;
import com.mamabologtub.library_system.services.BookRequestService;

/**
 * @Author Tshepo M Mahudu on Jul 16, 2025.
 */

@RestController
@RequestMapping("api/v2/book-requests")
public class BookRequestController {

    private BookRequestService bookRequestService;

    @GetMapping
    public List<BookRequest> getAllBookRequests(){
        return bookRequestService.getRequests();
    }
    @PostMapping
    public ResponseEntity<String> requestBook(@RequestBody BookRequestDto dto){

        bookRequestService.creatBookRequest(dto);
        return ResponseEntity.ok("Requested");

    }

    @Autowired
    public void setBookRequestService(BookRequestService bookRequestService) {
        this.bookRequestService = bookRequestService;
    }

}
