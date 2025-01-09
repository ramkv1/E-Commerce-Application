package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Address;
import com.ecommerce.repo.AddressRepository;
import com.ecommerce.service.I.IAddressService;


@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}


	@Override
	public Address getAdderess(Long addressId) {
		return addressRepository.findById(addressId).get();
	}
	
	@Override
	public Address editAddress(Address address,Long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeAddress(Long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

}
