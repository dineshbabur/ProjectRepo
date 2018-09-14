package com.coffee.house.service;

import java.util.List;

import com.coffee.house.domain.Customer;

public interface CustomerService {

	String addCustomer(Customer customer);

	int getCustomerSize();

	Customer getCustomer(String customerName, String customerPhone);

	List<String> getAllCustomer();

}
