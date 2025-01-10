package com.ecommerce.service;

import com.ecommerce.entity.Address;

public interface IAddressService {
	public Address addAddress(Address address);
	public Address getAdderess(Integer addressId);
}
