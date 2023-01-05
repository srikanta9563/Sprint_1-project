package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Cart;

public interface ItemRepo extends JpaRepository<Cart, Integer> {

}
