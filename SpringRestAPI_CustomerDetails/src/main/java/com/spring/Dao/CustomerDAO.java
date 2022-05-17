package com.spring.Dao;

import java.util.List;

import com.spring.model.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer customer) throws Exception;
	public Customer getCustomer(Integer customerId) throws Exception;
	public List<Customer> getAllCustomers() throws Exception;
	public void updateCustomer(Integer customerId,Customer Customer) throws Exception;
	public void deleteCustomer(Integer customerId) throws Exception;
	
}
