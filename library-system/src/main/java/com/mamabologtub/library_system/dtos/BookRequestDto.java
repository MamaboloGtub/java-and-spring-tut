package com.mamabologtub.library_system.dtos;

import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Jul 8, 2025.
 */

@Data
public class BookRequestDto {

    private Long id;
    private Long bookId;
    private String studentId;
    // private Long approvedByAdminId;

    //    private String bookTitle;
    //    private String studentName;
    //    private String adminName;
    //
    //    private LocalDate requestDate;
    //    private LocalDate approvalDate;
    //    private LocalDate dueDate;
    //    private LocalDate returnDate;
    //
    //    private String status;

}
