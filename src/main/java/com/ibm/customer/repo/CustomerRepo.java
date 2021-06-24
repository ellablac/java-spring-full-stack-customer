package com.ibm.customer.repo;

import com.ibm.customer.model.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long>{
	public Customer findByCustomerNumber(String custNumber);
}
