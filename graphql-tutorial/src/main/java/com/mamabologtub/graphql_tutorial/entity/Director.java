package com.mamabologtub.graphql_tutorial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Director {

    @Id
    @Column(name = "Id")
    private  Integer id;

    @Column(name = "Name", nullable = false)
    private String name;
}
