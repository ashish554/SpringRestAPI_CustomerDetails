package com.spring;

import org.junit.jupiter.api.Test;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.api.CustomerController;
import com.spring.model.Customer;
import com.spring.services.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {	
	
		@MockBean 
		CustomerService customerService;
		
		@Autowired
		private MockMvc mockMvc;
		
		Customer mockCourse = new Customer(1, "Ashu", "Ashu@infosys.com");
		
		@Test
		public void getCustomerTest() throws Exception
		{
			Mockito.when(customerService.getCustomer(Mockito.anyInt())).thenReturn(mockCourse);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/home/customers/1").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());
			String expected = "{customerId:1,cName:Ashu,cEmail:Ashu@infosys.com}";

			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		}
		}

	


