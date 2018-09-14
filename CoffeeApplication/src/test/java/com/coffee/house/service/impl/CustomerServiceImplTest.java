/**
 * 
 */
package com.coffee.house.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.coffee.house.dao.CustomerDaoImpl;
import com.coffee.house.domain.Customer;

/**
 * @author dinesh
 *
 */
@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {
	
	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerDaoImpl customerDao;

	Customer customer = new Customer("Dinesh", "8050908970");

	@Test
	public void testAddCustomer() {
		Mockito.doNothing().when(customerDao).add(customer);
		customerService.addCustomer(customer);
	}

	@Test
	public void testGetCustomerSize() {
		Mockito.when(customerDao.getSize()).thenReturn(1);
		int size = customerService.getCustomerSize();
		Assert.assertEquals(1, size);
	}

	@Test
	public void testGetCustomer() {
		Mockito.when(customerDao.getCustomer(Mockito.anyString())).thenReturn(customer);
		Customer cust = customerService.getCustomer("Dinesh","123232");
		Assert.assertEquals(customer.getCustomerName(), cust.getCustomerName());
	}

	@Test
	public void getAllCustomer() {
		Set<String> customerSet = new HashSet<String>();
		customerSet.add(customer.toString());
		Mockito.when(customerDao.getAllCustomer()).thenReturn(customerSet);
		Assert.assertEquals(customerSet.size(), 1);
	}
}
