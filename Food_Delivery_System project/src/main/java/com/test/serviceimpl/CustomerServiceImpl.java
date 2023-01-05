package com.test.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.exception.CustomerException;
import com.test.model.Cart;
import com.test.model.Customer;
import com.test.repository.CustomerRepo;
import com.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	@Override
	public String addCustomer(Customer c) throws CustomerException {
		Cart it = new Cart();
		List<Cart> item = new ArrayList<>();

		it.setItemName("Cheese Pizza");
		it.setQty(1);
		it.setPrice(400);

//		Cart it2 = new Cart();
//
//		it2.setItemName("Veg Burger");
//		it2.setQty(2);
//		it2.setPrice(100);
//
		item.add(it);

//		item.add(it2);

		it.setCust(c);

//		it2.setCust(c);

		c.setItemList(item);
		for (Cart cr : c.getItemList()) {
			cr.setCust(c);
		}
		custRepo.save(c);
		return "-- Customer added successfully --";
	}

	@Override
	public String updateCustomer(Customer temp, Integer id) throws CustomerException {
		Customer cust = custRepo.findById(id).get();
		cust.setAddress(temp.getAddress());
		cust.setPhone(temp.getPhone());
		cust.setFullName(temp.getFullName());
		custRepo.save(cust);
		return "-- Customer details updated successfully --";

	}

	@Override
	public String deleteCustomer(Integer id) throws CustomerException {
		custRepo.deleteById(id);
		return "Customer with id=" + id + " is deleted";
	}

	@Override
	public Customer viewCustomer(Integer id) throws CustomerException {

		Optional<Customer> c = custRepo.findById(id);
		return c.get();
	}

	@Override
	public List<Customer> viewAll() throws CustomerException {

		return custRepo.findAll();
	}

}
