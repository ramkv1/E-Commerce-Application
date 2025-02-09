package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Customer;
import com.ecommerce.repo.ICustomerRepository;


@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}

	@Override
	public Customer getCustomer(Integer cid) {
		
		return customerRepository.findById(cid).get();
	}

	@Override
	public Integer getCustomerByCustometName(String name) {
		return customerRepository.getCustomerByCustomerName(name);
	}

}
