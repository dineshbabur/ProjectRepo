/**
 * 
 */
package com.coffee.house.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coffee.house.domain.Coffee;

/**
 * @author dinesh
 *
 */
@Repository
public class CoffeeDaoImpl implements CoffeeDao {
	
	private static Map<String, Coffee> coffeeInventory = null;
	
	public CoffeeDaoImpl() {
		if(coffeeInventory == null) {
			coffeeInventory = new HashMap<String,Coffee>();
		}
	}
	
	@Override
	public void addCoffee(Coffee coffee) {
		coffeeInventory.put(coffee.getCoffeeName(), coffee);
	}

	@Override
	public int getSize() {
		return coffeeInventory.size();
	}

	@Override
	public Coffee getCoffee(String coffee) {
		return coffeeInventory.get(coffee);
	}

	@Override
	public Set<String> getAllCoffeeDetails() {
		return coffeeInventory.keySet();
	}

}
