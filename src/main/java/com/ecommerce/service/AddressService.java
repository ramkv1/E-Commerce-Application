package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Address;
import com.ecommerce.repo.IAddressRepository;


@Service("addressService")
public class AddressService implements IAddressService {
	
	@Autowired
	private IAddressRepository addressRepository;

	@Override
	public Address addAddress(Address address) {
		//save operation
		return addressRepository.save(address);
	}

	@Override
	public Address getAdderess(Integer addressId) {
		// select operation
		return addressRepository.findById(addressId).get();
	}

}
