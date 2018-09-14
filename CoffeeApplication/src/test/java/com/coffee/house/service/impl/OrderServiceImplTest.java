/**
 * 
 */
package com.coffee.house.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.coffee.house.dao.CoffeeDaoImpl;
import com.coffee.house.dao.OrderDaoImpl;
import com.coffee.house.domain.Coffee;
import com.coffee.house.domain.Order;
import com.coffee.house.domain.OrderList;
import com.coffee.house.service.CustomerService;

/**
 * @author dinesh
 *
 */
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
	@InjectMocks
	private OrderServiceImpl oderService;

	@Mock
	private OrderDaoImpl orderDao;
	
	@Mock
	private CustomerService customerService;


	@Test
	public void testAddCoffee() {
		OrderList orderList = new OrderList();
		Order order = new Order();
		order.setCoffeeName("Cappuccino");
		order.setQuantity(2);
		List<Order> orders = new ArrayList<Order>();
		orderList.setOrder(orders);
		orderList.setCustomerName("Dinesh");
		orderList.setCustomerPhone("8050908970");
		Mockito.doNothing().when(orderDao).placeOrder(orderList);
		oderService.placeOrder(orderList);
	}

}
