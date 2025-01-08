package com.ecommerce.service.I;

import com.ecommerce.entity.Customer;

public interface ICustomerService {
	
	public Customer createCustomer(Customer customer);
	public Customer getCustomer(Integer cid);
}
