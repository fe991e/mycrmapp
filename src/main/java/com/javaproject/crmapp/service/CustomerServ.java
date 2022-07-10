package com.javaproject.crmapp.service;

import java.util.List;

import com.javaproject.crmapp.entity.Customer;

public interface CustomerServ {
	List<Customer> findAll();
	Customer findById(int id);
	Customer addCust(Customer c);
	Customer updateCust(Customer c);
	void deleteCust(int id);
}
