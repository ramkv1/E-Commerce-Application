package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Customer;
import com.ecommerce.repo.CustomerRepository;
import com.ecommerce.service.I.ICustomerService;



@Service
public class CustomerServiceImpl implements ICustomerService{
	

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public Customer getCustomer(Integer cid) {
		return customerRepository.findById(cid)
                .orElse(null);
	}
	
	

}
