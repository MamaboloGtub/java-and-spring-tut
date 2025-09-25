package com.mamabologtub.grpahql_crud.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @Author Tshepo M Mahudu on Jun 29, 2025.
 */

@Entity
public class Book {

    @Id
    private UUID bookId;

    private Long isbn;
    private String author;
    private String title;

    /*
     * include category with ManyToOne relationship and also try to explore the request status,
     * PLan is to include a logic in services,  but we'll see
     * */


}
