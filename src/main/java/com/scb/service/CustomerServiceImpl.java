package com.scb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.scb.model.Customer;
import com.scb.repository.CustomerRepository;



@Service("custService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository custRepository;

	@Override
	public String getMobileNumber(Customer cust) {
		// TODO Auto-generated method stub
		return custRepository.getMobNumFromJdbc(cust);
	}

	@Override
	public String getPassword(Customer cust) {
		// TODO Auto-generated method stub
		return custRepository.getPassFromDb(cust);
	}

	@Override
	public List<Customer> getCardDets(Customer cust) {
		// TODO Auto-generated method stub
		return custRepository.getCardDetsFromDb(cust);
	}

	@Override
	public String getName(Customer cust) {
		// TODO Auto-generated method stub
		return custRepository.getNameFromDb(cust);
	}

	@Override
	public int enterDets(Customer cust) {
		return custRepository.enterDetsToDb(cust);
	}

	@Override
	public String getSubscribeDets(Customer cust) {
		return custRepository.getSubDetails(cust);
	}
}