package com.example.demo.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.model.Customer;
import com.example.demo.customer.repo.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
		
	}

}
