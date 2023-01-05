package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Cart;
import com.test.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	public CartService cartService;

	// add some food to cart

	@PostMapping("/test")
	public Cart addController(@RequestBody Cart cart) {
		return cartService.saveCart(cart);
	}

	// get all food details from cart

	@GetMapping(value = "/test")
	public List<Cart> getAllController() {
		return cartService.getAllItems();
	}

	// update foot items

	@PutMapping(value = "/test/{id}")
	public Cart updateController(@PathVariable int id, @RequestBody Cart cart) {
		return cartService.updateItem(cart, id);
	}

	// delete afood items

	@DeleteMapping(value = "/test/{id}")
	public String deleteController(@PathVariable int id) {
		return cartService.deleteItem(id);
	}

}
