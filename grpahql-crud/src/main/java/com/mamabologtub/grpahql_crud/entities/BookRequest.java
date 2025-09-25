package com.mamabologtub.grpahql_crud.entities;

import java.awt.print.Book;
import java.time.LocalDate;

import com.mamabologtub.grpahql_crud.enums.RequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @Author Tshepo M Mahudu on Jun 29, 2025.
 */

@Entity
public class BookRequest {

    @Id
    private Long requestId;

    //manytoOne
    private Book book;

    //manyToOne
    private Student student;

    //Many2One
    private Admin approvedBy;

    private LocalDate requestDate;
    private LocalDate approvalDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    //use enumarated annotation to convert to String
    private RequestStatus status;
}
