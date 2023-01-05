package com.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.exception.CustomerException;
import com.test.model.Customer;
import com.test.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	public CustomerService custService;

	@PostMapping(value = "/test")

	public String saveCust(@Valid @RequestBody Customer c) throws CustomerException {

		return custService.addCustomer(c);
	}

	@GetMapping(value = "/test/{id}")

	public Customer viewCust(@PathVariable Integer id) throws CustomerException {

		return custService.viewCustomer(id);
	}

	@PutMapping(value = "/test/{id}")

	public String editCust(@RequestBody Customer c, @PathVariable Integer id) throws CustomerException {

		return custService.updateCustomer(c, id);
	}

	@GetMapping(value = "/test")

	public List<Customer> viewALLCust() throws CustomerException {

		return custService.viewAll();
	}

	@DeleteMapping(value = "/test/{id}")

	public String deleteCustomer(@PathVariable Integer id) throws CustomerException {

		return custService.deleteCustomer(id);
	}

}
