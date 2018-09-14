/**
 * 
 */
package com.coffee.house.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coffee.house.domain.Customer;

/**
 * @author dinesh
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

	private static Map<String, Customer> customerDetails = null;

	public CustomerDaoImpl() {
		if (customerDetails == null) {
			customerDetails = new HashMap<String, Customer>();
		}
	}

	@Override
	public void add(Customer customer) {
		customerDetails.put(customer.getCustomerId(), customer);
	}

	@Override
	public int getSize() {
		return customerDetails.size();

	}

	@Override
	public Customer getCustomer(String customerId) {
		return customerDetails.get(customerId);
	}

	@Override
	public Set<String> getAllCustomer() {
		return customerDetails.keySet();

	}

}
