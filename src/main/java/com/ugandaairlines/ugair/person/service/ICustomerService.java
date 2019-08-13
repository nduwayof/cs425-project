package com.ugandaairlines.ugair.person.service;

import com.ugandaairlines.ugair.person.model.Customer;

public interface ICustomerService {
	
	public abstract Customer saveCustomer(Customer customer);
	public abstract Iterable<Customer> findAllCustomers();
	public abstract Customer findCustomerById(Integer customerId);
	public abstract void deleteCustomer(Customer customer);

}
