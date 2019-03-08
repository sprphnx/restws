package com.sprphnx.restws.service;

import java.util.List;
import java.util.Optional;

import com.sprphnx.restws.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Optional<Customer> getCustomerById(long id);

	public void createCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(long id);

}
