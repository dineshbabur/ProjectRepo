package com.coffee.house.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.house.domain.Customer;
import com.coffee.house.service.CustomerService;

@RestController
@RequestMapping("/CoffeeHouse/Customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerSerice;
	
	@PostMapping(path="/addCustomer",produces = "application/json")
	public String addCustomer(@Valid @RequestBody Customer customer) {
		String response =customerSerice.addCustomer(customer);
		return response;
	}
	@GetMapping(path="/getCustomer/{customerName}/{customerPhone}")
	public Customer getCustomer(@PathVariable("customerName") String customerName,@PathVariable("customerPhone") String customerPhone) {
		Customer cust = customerSerice.getCustomer(customerName,customerPhone);
		return cust;
	}
	@GetMapping("/getCustomerSize")
	public Integer getCustomerSize() {
		return customerSerice.getCustomerSize();
	}
	
	@GetMapping(path="/getAllCustomer")
	public List<String> getAllCustomer() {
		return customerSerice.getAllCustomer();
	}
	
}
