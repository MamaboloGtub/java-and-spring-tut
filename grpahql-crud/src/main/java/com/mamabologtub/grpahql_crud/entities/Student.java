package com.mamabologtub.grpahql_crud.entities;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

/**
 * @Author Tshepo M Mahudu on Jun 29, 2025.
 */

@Entity
public class Student {

    @Id
    private String studentId;

    private String fullNames;
    private String studentEmail;
    private Integer registrationYear;

    @PrePersist
    private void generateStudentId() {
        if (this.studentId == null || this.studentId.isBlank()) {
            String yearPart = String.valueOf(registrationYear).substring(2);
            int randomPart = new Random().nextInt(9000) + 1000;
            this.studentId = "st" + yearPart + randomPart;
        }
    }
}
