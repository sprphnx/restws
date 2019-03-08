package com.sprphnx.restws.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprphnx.restws.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = Arrays.asList(entityManager.find(Customer.class, 10001L));
		return customers;
	}

}
