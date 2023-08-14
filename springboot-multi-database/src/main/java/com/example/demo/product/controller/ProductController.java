package com.example.demo.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.model.Customer;
import com.example.demo.customer.repo.CustomerRepository;
import com.example.demo.product.model.Product;
import com.example.demo.product.repo.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/products")
	public Product saveProducts(@RequestBody Product product) {
		return productRepository.save(product);
		
	}

}
