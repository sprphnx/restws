package com.sprphnx.restws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprphnx.restws.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
