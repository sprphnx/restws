package com.sprphnx.restws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.restws.entity.Customer;
import com.sprphnx.restws.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/")
	public List<Customer> getAllEmployees() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public Customer getEmployeeById(@PathVariable long id) {
		return customerService.getCustomerById(id).isPresent() ? customerService.getCustomerById(id).get() : null;

	}
	
	@PostMapping("/")
	public void getEmployeeById(@RequestBody Customer customer) {
		 customerService.createCustomer(customer);

	}

}
