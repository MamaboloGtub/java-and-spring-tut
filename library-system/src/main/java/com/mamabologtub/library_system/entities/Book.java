package com.mamabologtub.library_system.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Jul 4, 2025.
 */

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    // this helps us when the values gets saved in the db because we have already defined the kind of Id we want in there.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String field;
    private String publisher;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookRequest> bookRequests;

    //    @ManyToOne
    //    private Category category;

    private boolean isavailable = true;

}
