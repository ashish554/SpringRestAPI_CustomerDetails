package com.spring.Dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.Customer;


@Repository(value="CustomerDAO")
public class CustomerDaoImpl implements CustomerDAO{
	
	HashMap<Integer,Customer> customers=new HashMap<Integer,Customer>();
	
	public CustomerDaoImpl()
	{
		try {
		ObjectMapper mapper = new ObjectMapper();
		List<Customer> customer = Arrays.asList(mapper.readValue(new File("src/main/resources/customer.json"), Customer[].class));
		for(int i=1;i<=customer.size();i++)
		{
			customers.put(i, customer.get(i-1));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void addCustomer(Customer customer) throws Exception {
			customers.put(customer.getCustomerId(), customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) throws Exception 
	{
		return customers.get(customerId);	    
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		List<Customer> customerList=new ArrayList<Customer>();
		for(Integer i:customers.keySet())
		{
			customerList.add(customers.get(i));
		}
		return customerList;
	}

	@Override
	public void updateCustomer(Integer customerId, Customer customer) throws Exception {
		customers.put(customerId,customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws Exception {
		customers.remove(customerId);
	}

}
