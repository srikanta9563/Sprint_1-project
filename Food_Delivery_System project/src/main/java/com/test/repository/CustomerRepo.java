package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
