/**
 * 
 */
package com.coffee.house.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.house.dao.OrderDao;
import com.coffee.house.domain.Coffee;
import com.coffee.house.domain.Customer;
import com.coffee.house.domain.Order;
import com.coffee.house.domain.OrderList;
import com.coffee.house.dto.Receipt;
import com.coffee.house.service.CoffeeService;
import com.coffee.house.service.CustomerService;
import com.coffee.house.service.OrderService;

/**
 * @author dinesh
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CoffeeService coffeeService;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public Receipt placeOrder(OrderList orderList) {
		Receipt receipt = new Receipt();
		List<Order> orders = orderList.getOrder();
		for(Order order: orders) {
			Coffee coffee = coffeeService.getCoffee(order.getCoffeeName());
			if(coffee != null) {
				if (coffee.getTotalNoOfServingFortheDay() > 0 && (coffee.getTotalNoOfServingFortheDay() - order.getQuantity()) > 0) {
					receipt.getOrders().add(order);
					coffee.setTotalNoOfServingSoldForTheDay(coffee.getTotalNoOfServingFortheDay() + 1);
					coffeeService.addCoffee(coffee);
					order.setOrderDate(new Date());
					order.setOrderId(""+Calendar.MILLISECOND);
				}else {
					receipt.getMessage().add((order.getCoffeeName()+" is not available in Quantity"+order.getQuantity() +"for the day"));
				}
			}else {
				receipt.getMessage().add((order.getCoffeeName()+" is not available"));
			}
		}
		Customer customer = customerService.getCustomer(orderList.getCustomerName(), orderList.getCustomerPhone());
		if(customer == null) {
			customerService.addCustomer(new Customer(orderList.getCustomerName(),orderList.getCustomerPhone()));
		}
		receipt.setCustomer(customer);
		orderDao.placeOrder(orderList);
		return receipt;
	}

}
