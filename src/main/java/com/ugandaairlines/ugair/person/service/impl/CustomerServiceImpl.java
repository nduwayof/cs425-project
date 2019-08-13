package com.ugandaairlines.ugair.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.person.model.Customer;
import com.ugandaairlines.ugair.person.repository.ICustomerRepository;
import com.ugandaairlines.ugair.person.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Iterable<Customer> findAllCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(Integer customerId) {

		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
		
	}

}
