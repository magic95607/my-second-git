package com.example.ch01_RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ch01_RestController.service.IProductService;

@RestController
public class ProductController {
  @Autowired
  private IProductService productService;
  @PostMapping("/product")
  public String createProduct(@RequestBody ProductEntity productEntity){
      productService.save(productEntity);
      return "Product create action";
  }
}
