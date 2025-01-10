package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.Customer;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
