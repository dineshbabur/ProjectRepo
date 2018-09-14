/**
 * 
 */
package com.coffee.house.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.house.constants.Constants;
import com.coffee.house.dao.CustomerDao;
import com.coffee.house.domain.Customer;
import com.coffee.house.service.CustomerService;

/**
 * @author dinesh
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public String addCustomer(Customer customer) {
		String customerId = customer.getCustomerName().concat(customer.getCustomerPhone());
		customer.setCustomerId(customerId);
		customerDao.add(customer);
		return Constants.SUCCESS;
	}

	@Override
	public int getCustomerSize() {
		return customerDao.getSize();
	}

	@Override
	public Customer getCustomer(String customerName, String customerPhone) {
		String customerId = customerName+customerPhone;
		return customerDao.getCustomer(customerId);
	}

	@Override
	public List<String> getAllCustomer() {
		List<String> result= new ArrayList<String>();
		Set<String> customerkeys = customerDao.getAllCustomer();
		for(String customerId:customerkeys) {
			result.add(customerDao.getCustomer(customerId).toString());
		}
		return result;
	}

}
