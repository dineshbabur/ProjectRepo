/**
 * 
 */
package com.coffee.house.domain;

import javax.validation.constraints.NotNull;

/**
 * @author dinesh
 *
 */
public class Coffee {
	@NotNull
	String coffeeName;
	String coffeeDescription;
	@NotNull
	int totalNoOfServingFortheDay = 0;
	int totalNoOfServingSoldForTheDay = 0;

	/**
	 * @return the coffeeName
	 */
	public String getCoffeeName() {
		return coffeeName;
	}

	/**
	 * @param coffeeName
	 *            the coffeeName to set
	 */
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	/**
	 * @return the coffeeDescription
	 */
	public String getCoffeeDescription() {
		return coffeeDescription;
	}

	/**
	 * @param coffeeDescription
	 *            the coffeeDescription to set
	 */
	public void setCoffeeDescription(String coffeeDescription) {
		this.coffeeDescription = coffeeDescription;
	}

	/**
	 * @return the totalNoOfServingFortheDay
	 */
	public int getTotalNoOfServingFortheDay() {
		return totalNoOfServingFortheDay;
	}

	/**
	 * @param totalNoOfServingFortheDay
	 *            the totalNoOfServingFortheDay to set
	 */
	public void setTotalNoOfServingFortheDay(int totalNoOfServingFortheDay) {
		this.totalNoOfServingFortheDay = totalNoOfServingFortheDay;
	}

	/**
	 * @return the totalNoOfServingSoldForTheDay
	 */
	public int getTotalNoOfServingSoldForTheDay() {
		return totalNoOfServingSoldForTheDay;
	}

	/**
	 * @param totalNoOfServingSoldForTheDay
	 *            the totalNoOfServingSoldForTheDay to set
	 */
	public void setTotalNoOfServingSoldForTheDay(int totalNoOfServingSoldForTheDay) {
		this.totalNoOfServingSoldForTheDay = totalNoOfServingSoldForTheDay;
	}

	@Override
	public String toString() {

		return "CoffeeName:" + this.coffeeName + "||  Total No.Of Servings for the Day:" + this.totalNoOfServingFortheDay
				+ " || Total No. Of Servings Sold for the Day:" + this.totalNoOfServingSoldForTheDay;
	}
	
	public Coffee(String coffeeName,String coffeeDescription,int totalNoOfServingFortheDay,int totalNoOfServingSoldForTheDay) {
		this.coffeeName = coffeeName;
		this.coffeeDescription = coffeeDescription;
		this.totalNoOfServingFortheDay= totalNoOfServingFortheDay;
		this.totalNoOfServingSoldForTheDay = totalNoOfServingSoldForTheDay;
	}
	
	public Coffee() {
		
	}

}
