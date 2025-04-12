package com.mamabologtub.employeemvc.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Apr 12, 2025.
 */
@Entity
@Data
public class JobPosting {

    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String location;
    private Long salary;
    private String employmentType; // change this to ENUMS
    private LocalDate postedDate;
    private LocalDate deadline;

}
