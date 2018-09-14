/**
 * 
 */
package com.coffee.house.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author dinesh
 *
 */
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String customerId;
	@NotNull
	public String customerName;
	@NotNull
	public String customerPhone;
	
	public Customer() {
		
	}
	
	public Customer(String customerName,String customerPhone) {
		this.customerId = customerName+customerPhone;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	
	@Override
	public String toString() {
		return "CustomerName:"+customerName+",CustomerPhone:"+customerPhone;
	}
}
