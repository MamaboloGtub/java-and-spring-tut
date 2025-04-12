package com.mamabologtub.employeemvc.models;

import jakarta.persistence.Entity;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Apr 12, 2025.
 */
@Entity
@Data
public class Employee {

    private Long id;

    private String name;
    private String surname;
    private Integer empNumber;
    private String email;

    // change these two to ENUMS
    private String position;
    private String department;

}
