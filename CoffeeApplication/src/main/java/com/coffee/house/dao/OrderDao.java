/**
 * 
 */
package com.coffee.house.dao;

import com.coffee.house.domain.Order;
import com.coffee.house.domain.OrderList;

/**
 * @author dinesh
 *
 */
public interface OrderDao {

	Order placeOrder(Order order);

	void placeOrder(OrderList orderList);

}
