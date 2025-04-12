package com.mamabologtub.employeemvc.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Apr 12, 2025.
 */

@Entity
@Data
public class JobApplication {

    private String applicantName;
    private String applicantSurname;
    private String applicantEmail;
    private String jobId;
    private LocalDate applicationDate;
    private String resume;
    private String coverLetter;
    private String phoneNumber;
    private String address;
    private List<String> references;

    // use ENUMS here
    private List<String> experience;
    private List<String> qualifications;
    private List<String> skills;

    //map jobPosting here

}
