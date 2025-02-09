package com.ecommerce.service;

import com.ecommerce.entity.Customer;

public interface ICustomerService {
	public Customer createCustomer(Customer customer);
	public Customer getCustomer(Integer cid);
	public Integer getCustomerByCustometName(String name);

}
