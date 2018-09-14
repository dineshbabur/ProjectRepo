/**
 * 
 */
package com.coffee.house.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.coffee.house.constants.Constants;
import com.coffee.house.domain.Coffee;
import com.coffee.house.service.impl.CoffeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author dinesh
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CoffeeController.class, secure = false)
public class CoffeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CoffeeServiceImpl coffeeService;

	Coffee coffee = new Coffee("Cappuccino", "Cappuccino",100,10);

	@Test
	public void testGetCoffeeSize() throws Exception {
		Mockito.when(coffeeService.getCoffeeSize()).thenReturn(0);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/CoffeeHouse/Coffee/getCoffeeSize");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("REsult::::" + mvcResult.getResponse());
		Assert.assertEquals("0", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testGetCoffee() throws Exception {
		Mockito.when(coffeeService.getCoffee(Mockito.anyString())).thenReturn(coffee);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/CoffeeHouse/Coffee/getCoffee/Cappuccino")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = (new ObjectMapper()).valueToTree(coffee).toString();
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testAddCoffee() throws Exception {
		String body = (new ObjectMapper()).valueToTree(coffee).toString();
		Mockito.when(coffeeService.addCoffee(Mockito.anyObject())).thenReturn(Constants.SUCCESS);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/CoffeeHouse/Coffee/addCoffee")
				.contentType(MediaType.APPLICATION_JSON).content(body);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals(Constants.SUCCESS, result.getResponse().getContentAsString());
	}
	@Test
	public void testGetAllCoffee() throws Exception {
		List<String> customerList = new ArrayList<String>();
		customerList.add(coffee.toString());
		Mockito.when(coffeeService.getAllCoffee()).thenReturn(customerList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/CoffeeHouse/Coffee/getAllCoffee");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[\"CoffeeName:Cappuccino||  Total No.Of Servings for the Day:100 || Total No. Of Servings Sold for the Day:10\"]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
