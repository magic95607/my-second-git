package com.example.ch01_RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ch01_RestController.entity.ProductEntity;

@Controller
public class ThymeleafController {
	@GetMapping("/home")
	public String home(Model model){
	    ProductEntity product = new ProductEntity();
	    product.setId(1);
	    product.setName("Car");
	    product.setPrice(300000.0);
	    model.addAttribute("product", product);
	    return "index";
	}
}
