/**
 * 
 */
package com.coffee.house.service;

import java.util.List;

import com.coffee.house.domain.Coffee;

/**
 * @author dinesh
 *
 */

public interface CoffeeService {

	String addCoffee(Coffee coffee);
	
	int getCoffeeSize();

	Coffee getCoffee(String coffeeName);

	List<String> getAllCoffee();
	
}
