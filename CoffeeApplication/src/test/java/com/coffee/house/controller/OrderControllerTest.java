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
import com.coffee.house.domain.Order;
import com.coffee.house.domain.OrderList;
import com.coffee.house.dto.Receipt;
import com.coffee.house.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author dinesh
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderController.class, secure = false)
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderServiceImpl orderService;

	OrderList orderList = new OrderList();
	Order order = new Order();
	

	@Test
	public void testAddCoffee() throws Exception {
		Receipt receipt = new Receipt();
		order.setCoffeeName("Cappuccino");
		order.setQuantity(2);
		List<Order> orders = new ArrayList<Order>();
		orderList.setOrder(orders);
		orderList.setCustomerName("Dinesh");
		orderList.setCustomerPhone("8050908970");
		String body = (new ObjectMapper()).valueToTree(orderList).toString();
		String expected = (new ObjectMapper()).valueToTree(receipt).toString();
		Mockito.when(orderService.placeOrder((Mockito.anyObject()))).thenReturn(receipt);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/CoffeeHouse/Order/placeOrder")
				.contentType(MediaType.APPLICATION_JSON).content(body);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
