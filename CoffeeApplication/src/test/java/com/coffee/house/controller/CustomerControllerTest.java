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
import com.coffee.house.domain.Customer;
import com.coffee.house.service.impl.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author dinesh
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class, secure = false)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerServiceImpl customerService;

	Customer customer = new Customer("Dinesh", "1234567890");

	@Test
	public void testGetCustomerSize() throws Exception {
		Mockito.when(customerService.getCustomerSize()).thenReturn(0);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/CoffeeHouse/Customer/getCustomerSize");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("REsult::::" + mvcResult.getResponse());
		Assert.assertEquals("0", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testGetCustomer() throws Exception {
		Mockito.when(customerService.getCustomer(Mockito.anyString(), Mockito.anyString())).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/CoffeeHouse/Customer/getCustomer/dinesh/12232")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"customerId\":\"Dinesh1234567890\",\"customerName\":\"Dinesh\",\"customerPhone\":\"1234567890\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testAddCustomer() throws Exception {
		String body = (new ObjectMapper()).valueToTree(customer).toString();
		Mockito.when(customerService.addCustomer(Mockito.anyObject())).thenReturn(Constants.SUCCESS);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/CoffeeHouse/Customer/addCustomer")
				.contentType(MediaType.APPLICATION_JSON).content(body);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals(Constants.SUCCESS, result.getResponse().getContentAsString());
	}
	@Test
	public void testGetAllCustomer() throws Exception {
		List<String> customerList = new ArrayList<String>();
		customerList.add(customer.toString());
		Mockito.when(customerService.getAllCustomer()).thenReturn(customerList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/CoffeeHouse/Customer/getAllCustomer");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[\n" + 
				"    \"CustomerName:Dinesh,CustomerPhone:1234567890\"\n" + 
				"]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
