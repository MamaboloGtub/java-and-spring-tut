package com.mamabologtub.employeemvc.models;

import java.util.Random;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Apr 12, 2025.
 */
@Entity
@Data
public class Employee {

    private UUID id;

    private String name;
    private String surname;
    private Integer empNumber;
    private String email;

    // change these two to ENUMS
    private String position;
    private String department;

    @PrePersist
    public void generateEmployeeNumber() {
        if (empNumber == null) {
            this.empNumber = 1000 + new Random().nextInt(9000);
        }
    }

}
