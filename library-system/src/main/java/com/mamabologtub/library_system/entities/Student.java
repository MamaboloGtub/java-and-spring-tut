package com.mamabologtub.library_system.entities;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Jul 7, 2025.
 */

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    // we do not need to include the @GeneratedValue because we are pre persisting the id.
    private String id;

    private String fullName;
    private String email;
    private Long registrationYear;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookRequest> bookRequests;

    @PrePersist
    private void generateStudentId() {
        if (this.id == null || this.id.isBlank()) {
            String yearPart = String.valueOf(registrationYear).substring(2);
            int randomPart = new Random().nextInt(9000) + 1000;
            this.id = "st" + yearPart + randomPart;
        }
    }
    /*
     * this prepersist function will help to generate student numbers
     * based on the year of registration and four random numbers,  this will
     * then be prefixed with letters st for student
     *
     * */


}
