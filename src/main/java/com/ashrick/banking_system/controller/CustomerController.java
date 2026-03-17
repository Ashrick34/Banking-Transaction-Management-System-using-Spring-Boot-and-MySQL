package com.ashrick.banking_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashrick.banking_system.entity.Customer;
import com.ashrick.banking_system.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	
}
