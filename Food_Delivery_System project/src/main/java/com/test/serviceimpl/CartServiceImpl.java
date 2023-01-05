package com.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Cart;
import com.test.model.Customer;
import com.test.repository.ItemRepo;
import com.test.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ItemRepo ir;

	@Override
	public Cart saveCart(Cart cart) {
		Customer cust = new Customer();

		return ir.save(cart);
	}

	@Override
	public Cart findByCartId(int cartId) {

		return ir.findById(cartId).get();
	}

	@Override
	public List<Cart> getAllItems() {

		return ir.findAll();
	}

	@Override
	public String deleteItem(int id) {

		ir.deleteById(id);
		return "Item removed from cart!!!";
	}

	@Override
	public Cart updateItem(Cart cart, int id) {

		Cart temp = ir.findById(id).get();
		temp.setPrice(cart.getPrice());
		temp.setQty(cart.getQty());

		return ir.save(temp);
	}

}
