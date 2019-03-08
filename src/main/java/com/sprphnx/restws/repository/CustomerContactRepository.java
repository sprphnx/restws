package com.sprphnx.restws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprphnx.restws.entity.CustomerContact;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

}
