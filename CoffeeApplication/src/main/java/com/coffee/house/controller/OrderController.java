/**
 * 
 */
package com.coffee.house.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.house.domain.OrderList;
import com.coffee.house.dto.Receipt;
import com.coffee.house.service.OrderService;

/**
 * @author dinesh
 *
 */
@RestController
@RequestMapping("/CoffeeHouse/Order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public Receipt addCustomer(@Valid @RequestBody OrderList orderList) {
		return orderService.placeOrder(orderList);
	}
}
