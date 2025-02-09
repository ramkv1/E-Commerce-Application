package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ecommerce.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Procedure(name = "Customer.getCustomerByCustomerName")
	Integer getCustomerByCustomerName(@Param("customer_Name") String name);

}
