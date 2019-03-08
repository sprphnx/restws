package com.sprphnx.restws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprphnx.restws.dao.CustomerDAO;
import com.sprphnx.restws.entity.Customer;
import com.sprphnx.restws.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}
	
	@Override
	public Optional<Customer> getCustomerById(long id) {
		
		return customerRepository.findById(id);
	}

	@Override
	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

}
