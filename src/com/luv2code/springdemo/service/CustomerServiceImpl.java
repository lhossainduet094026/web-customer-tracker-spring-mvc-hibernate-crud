package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service // spring will scan this class through component scanning to identify this holds
			// business logics
public class CustomerServiceImpl implements CustomerService {

	// inject customerDAO because service contact with dao to get data
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional // spring will automatically transaction management(begin transaction and commit
					// transaction)
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();// delegate calls to DAO
	}

	@Override
	@Transactional // spring will automatically maintain begin/commit the transaction
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);// delegate to customar DAO

	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);
	}

}
