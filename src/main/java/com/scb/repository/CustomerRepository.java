package com.scb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.model.Customer;


public interface CustomerRepository{

	 String getMobNumFromJdbc(Customer cust);

	String getPassFromDb(Customer cust);

	List<Customer> getCardDetsFromDb(Customer cust);

	String getNameFromDb(Customer cust);

	int enterDetsToDb(Customer cust);

	String getSubDetails(Customer cust);

}
