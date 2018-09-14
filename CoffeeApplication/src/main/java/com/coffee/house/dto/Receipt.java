/**
 * 
 */
package com.coffee.house.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.coffee.house.domain.Customer;
import com.coffee.house.domain.Order;

/**
 * @author dinesh
 *
 */
public class Receipt {
	List<Order> orders;
	private List<String> message;
	private Customer customer;
	public List<String> getMessage() {
		if(CollectionUtils.isEmpty(message)) {
			message = new ArrayList<String>();
		}
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(List<String> message) {
		this.message = message;
	}
	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		if(CollectionUtils.isEmpty(orders)) {
			orders = new ArrayList<Order>();
		}
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
