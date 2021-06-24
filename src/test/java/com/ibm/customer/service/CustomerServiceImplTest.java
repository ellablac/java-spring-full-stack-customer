package com.ibm.customer.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.verify;

import com.ibm.customer.model.Customer;
import com.ibm.customer.repo.CustomerRepo;

class CustomerServiceImplTest {
	// A mock MenuEndpoint object will be created and
	// injected so that OrderService can be unit-tested
	// in isolation.
	
	@Mock
	private CustomerRepo customerRepo;
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	// Scan this class and process the Mockito annotations
    @BeforeEach
    public void init() {
       MockitoAnnotations.initMocks(this);
    }
    
    @DisplayName("Test GetCustomer with an existing customer.")
	@Test
	void testGetCustomer() {
    	// Given - set the parameter values and mock the methods for this test case
        String customerNum = "CUST-1";
        Customer customerMocked = new Customer(customerNum, 
        		"George", "Washington", "gw@email.com");

        when(customerRepo.findByCustomerNumber(customerNum)).thenReturn(customerMocked);
        
        // When - call the method being tested and save the response
        Customer customer = customerService.getCustomer(customerNum);
        
        // Then - check that the results are valid (and that the expected mocked methods were called)
        assertNotNull(customer, "customer should not be null");
        assertEquals(customer, customerMocked, "customer should be the same as: " + customerMocked);
     
        verify(customerRepo).findByCustomerNumber(customerNum);

	}
}