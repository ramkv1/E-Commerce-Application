package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

}
