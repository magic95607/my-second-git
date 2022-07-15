package com.example.ch01_RestController;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRICE")
    private Double price;


}
