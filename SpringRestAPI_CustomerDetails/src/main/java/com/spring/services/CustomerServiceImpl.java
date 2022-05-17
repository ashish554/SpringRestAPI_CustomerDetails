package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Dao.CustomerDAO;
import com.spring.model.Customer;

@Service(value="CustomerService")
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired CustomerDAO customerdao;
	
	@Override
	public void addCustomer(Customer customer) throws Exception {
		if(customerdao.getCustomer(customer.getCustomerId())!=null)
		{
			throw new Exception("Service.Customer_Already_Exists");
		}
		customerdao.addCustomer(customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) throws Exception {
		Customer customer=customerdao.getCustomer(customerId);
		if (customer==null)
		{
			throw new Exception("Service.Customer_Unavailable");
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		List<Customer> customerList=customerdao.getAllCustomers();
		return customerList;
	}

	@Override
	public void updateCustomer(Integer customerId, Customer customer) throws Exception {
		if(customerdao.getCustomer(customerId)==null)
		{
			throw new Exception("Service.Customer_Not_Exists");
		}
		customerdao.updateCustomer(customerId,customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws Exception {
		if(customerdao.getCustomer(customerId)==null)
		{
			throw new Exception("Service.Customer_Not_Exists");
		}
		customerdao.deleteCustomer(customerId);
		
	}

}
