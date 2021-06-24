package com.ibm.customer.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.customer.model.Customer;
import com.ibm.customer.repo.CustomerRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer getCustomer(String customerNumber) {
		
		logger.info("Entered CustomerServiceImpl.getCustomer().  customerNumber=" + customerNumber);
		
		Customer customer = this.customerRepo.findByCustomerNumber(customerNumber);
		
		logger.info("Leaving CustomerServiceImpl.getCustomer().  customer=" + customer);
		
		return customer;
	}
	
	@Override
	public List<Customer> getCustomers() {
		
		logger.info("Entered CustomerServiceImpl.getCustomerS().");
		
		List<Customer> customers = this.customerRepo.findAll();
		
		return customers;
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		logger.info("Entered CustomerServiceImpl.addCustomer().  customer=" + customer);
		
		customer = this.customerRepo.insert(customer);
		
		return customer;
	}
}

