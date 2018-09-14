/**
 * 
 */
package com.coffee.house.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.house.domain.Coffee;
import com.coffee.house.service.CoffeeService;

/**
 * @author dinesh
 *
 */
@RestController
@RequestMapping("/CoffeeHouse/Coffee")
public class CoffeeController {
	@Autowired
	private CoffeeService coffeeService;
	
	@PostMapping("addCoffee")
	public String addCoffee(@Valid @RequestBody Coffee coffee) {
		return coffeeService.addCoffee(coffee);
	}
	
	@GetMapping("/getCoffee/{coffeeName}")
	public Coffee getCustomer(@PathVariable("coffeeName") String coffeeName) {
		Coffee coffee = coffeeService.getCoffee(coffeeName);
		return coffee;
	}
	@GetMapping("/getCoffeeSize")
	public Integer getCustomerSize() {
		return coffeeService.getCoffeeSize();
	}
	
	@GetMapping("/getAllCoffee")
	public List<String> getAllCoffee() {
		return coffeeService.getAllCoffee();
	}
	
	
}
