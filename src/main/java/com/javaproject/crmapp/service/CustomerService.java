package com.javaproject.crmapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.crmapp.dao.CustomerDAO;
import com.javaproject.crmapp.entity.Customer;

@Service
public class CustomerService implements CustomerServ {
	@Autowired
	private CustomerDAO custmrDAO;

	@Override
	@Transactional
	public List<Customer> findAll() {
		return custmrDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int id) {
		return custmrDAO.findById(id);
	}

	@Override
	@Transactional
	public Customer addCust(Customer c) {
		return custmrDAO.addCust(c);
	}

	@Override
	@Transactional
	public Customer updateCust(Customer c) {
		return custmrDAO.updateCust(c);
	}

	@Override
	@Transactional
	public void deleteCust(int id) {
		custmrDAO.deleteCustById(id);
	}

}
