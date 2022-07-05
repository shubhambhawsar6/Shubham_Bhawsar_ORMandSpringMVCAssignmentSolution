package com.greatlearning.management.service;

import java.util.List;

import com.greatlearning.management.entity.Customer;

public interface CustomerService {

	 public List<Customer> findAll();
	 
	 public Customer findByid(Integer id);
	 
	 public void save(Customer customer);

	  public void delete(Customer customer);

	public List<Customer> findByfirstName(String firstName);

}
