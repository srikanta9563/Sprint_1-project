package com.test.service;

import java.util.List;

import com.test.model.Cart;

public interface CartService {

	public Cart saveCart(Cart cart);

	public Cart findByCartId(int cId);

	List<Cart> getAllItems();

	String deleteItem(int id);

	Cart updateItem(Cart cart, int id);

}
