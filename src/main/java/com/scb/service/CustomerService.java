package com.scb.service;

import java.util.List;

import com.scb.model.Customer;

public interface CustomerService {

	String getMobileNumber(Customer cust);

	String getPassword(Customer cust);

	List<Customer> getCardDets(Customer cust);
	
	String getName (Customer cust);

	int enterDets(Customer cust);

	String getSubscribeDets(Customer cust);
}