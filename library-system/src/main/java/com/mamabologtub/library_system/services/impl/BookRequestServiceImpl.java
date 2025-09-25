package com.mamabologtub.library_system.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mamabologtub.library_system.dtos.BookRequestDto;
import com.mamabologtub.library_system.entities.Book;
import com.mamabologtub.library_system.entities.BookRequest;
import com.mamabologtub.library_system.entities.Student;
import com.mamabologtub.library_system.enums.RequestStatus;
import com.mamabologtub.library_system.exception.CustomException;
import com.mamabologtub.library_system.repositories.BookRequestRepository;
import com.mamabologtub.library_system.repositories.BooksRepository;
import com.mamabologtub.library_system.repositories.StudentsRepository;
import com.mamabologtub.library_system.services.BookRequestService;

/**
 * @Author Tshepo M Mahudu on Jul 16, 2025.
 */

@Service
public class BookRequestServiceImpl implements BookRequestService {

    private BooksRepository booksRepository;
    private StudentsRepository studentsRepository;
    private BookRequestRepository bookRequestRepository;

    @Override
    public BookRequest creatBookRequest(BookRequestDto dto) {
        Student student = studentsRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Book book = booksRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.isIsavailable()) {
            book.setIsavailable(false);
            booksRepository.save(book);
        } else {
            throw new CustomException("This book is not available for request", HttpStatus.LOCKED.value());
        }

        BookRequest request = new BookRequest();
        request.setStudent(student);
        request.setBook(book);
        request.setRequestDate(LocalDate.now());
        request.setStatus(RequestStatus.PENDING);
        return bookRequestRepository.save(request);
    }

    @Autowired
    public void setBooksRepository(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Autowired
    public void setBookRequestRepository(BookRequestRepository bookRequestRepository) {
        this.bookRequestRepository = bookRequestRepository;
    }

    @Override
    public List<BookRequest> getRequests() {
        return bookRequestRepository.findAll();
    }

}
