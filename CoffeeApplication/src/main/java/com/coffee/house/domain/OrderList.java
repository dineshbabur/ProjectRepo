/**
 * 
 */
package com.coffee.house.domain;

import java.util.List;

/**
 * @author dinesh
 *
 */
public class OrderList {
	private List<Order> order;
	private String customerName;
	private String customerPhone;

	/**
	 * @return the order
	 */
	public List<Order> getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(List<Order> order) {
		this.order = order;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * @param customerPhone the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	
}
