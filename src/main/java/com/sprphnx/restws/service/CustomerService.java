package com.sprphnx.restws.service;

import java.util.List;
import java.util.Optional;

import com.sprphnx.restws.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Optional<Customer> getCustomerById(long id);
	
}
