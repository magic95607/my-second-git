package com.example.ch01_RestController.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ch01_RestController.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

}
