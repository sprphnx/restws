package com.sprphnx.restws.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.restws.entity.hr.Region;
import com.sprphnx.restws.entity.vybha.Customer;
import com.sprphnx.restws.repository.hr.RegionRepository;
import com.sprphnx.restws.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	RegionRepository regionRepository;
	
	@PersistenceContext(unitName="hr") //This is the persistance unit name defined in the HRDSConfiguration.
	EntityManager entityManager;
	
	@GetMapping("/")
	public List<Customer> getAllEmployees() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/regions")
	public Region getAllRegions() {
		//return regionRepository.findAll();
		return entityManager.find(Region.class, 1L);
	}
	
	@PostMapping("/regions")
	@Transactional(value = "hrTransactionManager") // Specifying which datasources transaction manager to be used.
	public void getAllRegions(@RequestBody Region region) {
		entityManager.persist(region);
	}
	
	@GetMapping("/{id}")
	public Customer getEmployeeById(@PathVariable long id) {
		return customerService.getCustomerById(id).isPresent() ? customerService.getCustomerById(id).get() : null;

	}
	
	@PostMapping("/")
	public void createCustomer(@RequestBody Customer customer) {
		 customerService.createCustomer(customer);

	}
	
	@PutMapping("/")
	public void updateCustomer(@RequestBody Customer customer) {
		 customerService.updateCustomer(customer);

	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable long id) {
		 customerService.deleteCustomer(id);

	}
}
