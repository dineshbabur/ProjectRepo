/**
 * 
 */
package com.coffee.house.service;

import com.coffee.house.domain.OrderList;
import com.coffee.house.dto.Receipt;

/**
 * @author dinesh
 *
 */
public interface OrderService {

	Receipt placeOrder(OrderList order);

}
