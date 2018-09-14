/**
 * 
 */
package com.coffee.house.dao;

import java.util.Set;

import com.coffee.house.domain.Coffee;

/**
 * @author dinesh
 *
 */
public interface CoffeeDao {

	void addCoffee(Coffee coffee);
	public int getSize();
	public Coffee getCoffee(String coffee);
	public Set<String> getAllCoffeeDetails();

}
