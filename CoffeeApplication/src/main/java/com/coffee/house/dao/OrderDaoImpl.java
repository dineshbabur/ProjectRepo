/**
 * 
 */
package com.coffee.house.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coffee.house.domain.Order;
import com.coffee.house.domain.OrderList;

/**
 * @author dinesh
 *
 */
@Repository
public class OrderDaoImpl implements OrderDao {

	private static List<Order> orders = null;

	public OrderDaoImpl() {
		if (orders == null) {
			orders = new ArrayList<Order>();
		}
	}

	@Override
	public Order placeOrder(Order order) {
			orders.add(order);
		return order;
	}

	@Override
	public void placeOrder(OrderList orderList) {
		orders.addAll(orderList.getOrder());
	}

}
