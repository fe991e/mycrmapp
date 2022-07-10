package com.javaproject.crmapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaproject.crmapp.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private EntityManager eManager;
	//AutoWiring is Automatic here
	public CustomerDAOImpl(EntityManager eManager) {
		this.eManager = eManager;
	}

	@Override
	public List<Customer> findAll() {
		// .createQuery
		List<Customer> customers = eManager.createQuery("from Customer", Customer.class).getResultList();	
		return customers;
	}

	@Override
	public Customer findById(int id) {
		// .find		
		return eManager.find(Customer.class, id);
	}

	@Override
	public Customer addCust(Customer c) {
		// .persist
		eManager.persist(c);
		return c;
	}

	@Override
	public Customer updateCust(Customer c) {
		// .merge
		Customer cust = eManager.merge(c);
		c.setId(cust.getId()); //for REST API
		return c;
	}

	@Override
	public void deleteCustById(int id) {
		// eManager.remove(c);
		Query q = eManager.createQuery("delete from Customer where id=:idToDel");
		q.setParameter("idToDel", id);
		q.executeUpdate();
	}

}
