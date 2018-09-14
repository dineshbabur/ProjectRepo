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
import org.springframework.test.context.junit4.SpringRunner;

import com.coffee.house.dao.CoffeeDaoImpl;
import com.coffee.house.domain.Coffee;

/**
 * @author dinesh
 *
 */
@RunWith(SpringRunner.class)
public class CoffeeServiceImplTest {

	@InjectMocks
	private CoffeeServiceImpl coffeeService;

	@Mock
	private CoffeeDaoImpl coffeeDao;

	Coffee coffee = new Coffee("Cappuccino", "Cappuccino", 100, 10);

	@Test
	public void testAddCoffee() {
		Mockito.doNothing().when(coffeeDao).addCoffee(coffee);
		coffeeService.addCoffee(coffee);
	}

	@Test
	public void testGetCoffeeSize() {
		Mockito.when(coffeeDao.getSize()).thenReturn(1);
		int size = coffeeService.getCoffeeSize();
		Assert.assertEquals(1, size);
	}

	@Test
	public void testGetCoffee() {
		Mockito.when(coffeeDao.getCoffee(Mockito.anyString())).thenReturn(coffee);
		Coffee cof = coffeeService.getCoffee("Latte");
		Assert.assertEquals(coffee.getCoffeeName(), cof.getCoffeeName());
	}

	@Test
	public void getAllCoffee() {
		Set<String> coffeeSet = new HashSet<String>();
		coffeeSet.add(coffee.toString());
		Mockito.when(coffeeDao.getAllCoffeeDetails()).thenReturn(coffeeSet);
		Assert.assertEquals(coffeeSet.size(), 1);
	}
}
