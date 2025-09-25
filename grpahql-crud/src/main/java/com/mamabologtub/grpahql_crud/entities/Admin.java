package com.mamabologtub.grpahql_crud.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @Author Tshepo M Mahudu on Jun 29, 2025.
 */

@Entity
public class Admin {

    @Id
    private UUID adminId;

    private String adminName;
    private String adminEmail;


}
