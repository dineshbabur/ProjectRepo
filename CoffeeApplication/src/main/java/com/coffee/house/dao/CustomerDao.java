/**
 * 
 */
package com.coffee.house.dao;

import java.util.Set;

import com.coffee.house.domain.Customer;

/**
 * @author dinesh
 *
 */
public interface CustomerDao {
	public void add(Customer customer);
	public int getSize();
	public Customer getCustomer(String customerId);
	public Set<String> getAllCustomer();
}
