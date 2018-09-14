/**
 * 
 */
package com.coffee.house.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.house.constants.Constants;
import com.coffee.house.dao.CoffeeDao;
import com.coffee.house.domain.Coffee;
import com.coffee.house.service.CoffeeService;

/**
 * @author dinesh
 *
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {
	
	@Autowired
	private CoffeeDao coffeeDao;
	
	@Override
	public String addCoffee(Coffee coffee) {
		coffeeDao.addCoffee(coffee);
		return Constants.SUCCESS;
	}

	@Override
	public int getCoffeeSize() {
		return coffeeDao.getSize();
	}

	@Override
	public Coffee getCoffee(String coffeeName) {
		return coffeeDao.getCoffee(coffeeName);
	}

	@Override
	public List<String> getAllCoffee() {
		List<String> result= new ArrayList<String>();
		Set<String> coffeekeys = coffeeDao.getAllCoffeeDetails();
		for(String coffee:coffeekeys) {
			result.add(coffeeDao.getCoffee(coffee).toString());
		}
		return result;
	}

}
