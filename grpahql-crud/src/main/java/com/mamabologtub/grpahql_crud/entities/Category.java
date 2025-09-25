package com.mamabologtub.grpahql_crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @Author Tshepo M Mahudu on Jun 29, 2025.
 */

@Entity
public class Category {

    @Id
    private Long categoryId;

    private String categoryName;

    /*
     * explore the oneToMany with books
     * List the of books.
     * */

}
