package com.example.demo.product.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.customer.model.Customer;
import com.example.demo.product.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
