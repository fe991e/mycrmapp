package com.javaproject.crmapp.dao;

import java.util.List;

import com.javaproject.crmapp.entity.Customer;

public interface CustomerDAO {
	List<Customer> findAll();
	Customer findById(int id);
	Customer addCust(Customer c);
	Customer updateCust(Customer c);
	void deleteCustById(int id);
}
