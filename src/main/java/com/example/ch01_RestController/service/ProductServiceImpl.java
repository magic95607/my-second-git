package com.example.ch01_RestController.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ch01_RestController.ProductEntity;
import com.example.ch01_RestController.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void save(ProductEntity productEntity) {
		productRepository.save(productEntity);
	}
}
