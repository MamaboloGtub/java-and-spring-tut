package com.mamabologtub.library_system.entities;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Jul 7, 2025.
 */

@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    private String id;

    private String fullName;
    private String email;

    @PrePersist
    private void generateId() {
        if (this.id == null || this.id.isBlank()) {
            int randomNum = new Random().nextInt(9000) + 1000;
            this.id = "emp" + randomNum;
        }
    }

}
