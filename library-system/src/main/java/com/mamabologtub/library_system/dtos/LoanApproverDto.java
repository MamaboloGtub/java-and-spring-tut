package com.mamabologtub.library_system.dtos;

import java.time.LocalDate;

import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Sep 7, 2025.
 */

@Data
public class LoanApproverDto {

    private Long id;
    private String adminId;
    private Long requestId;
    private LocalDate decisionDate;
}
