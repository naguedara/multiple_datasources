package com.example.demo.customer.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.customer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
