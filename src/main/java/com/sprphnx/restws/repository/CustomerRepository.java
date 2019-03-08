package com.sprphnx.restws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprphnx.restws.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
