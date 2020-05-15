package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository // use to find through component scanning and translate exceptions
public class CustomerDAOImpl implements CustomerDAO {
//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query.....sort by lastName
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		// save the customer
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);// saving/updating using hibernate session
	}

	@Override
	public Customer getCustomer(int theId) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// get custmer from database using their primary key and return it
		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		//delete the customer using primary key
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId",id);
		theQuery.executeUpdate();
		
	}

}
