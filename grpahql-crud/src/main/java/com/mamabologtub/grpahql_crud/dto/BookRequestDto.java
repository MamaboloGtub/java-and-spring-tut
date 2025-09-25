package com.mamabologtub.grpahql_crud.dto;

import java.time.LocalDate;

/**
 * @Author Tshepo M Mahudu on Jun 29, 2025.
 */

public class BookRequestDto {

    private Long id;
    private Long bookId;
    private Long studentId;
    private Long approvedByAdminId;

    private String bookTitle;
    private String studentName;
    private String adminName;

    private LocalDate requestDate;
    private LocalDate approvalDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private String status;

}
