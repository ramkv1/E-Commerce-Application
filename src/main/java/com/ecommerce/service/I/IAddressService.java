package com.ecommerce.service.I;

import com.ecommerce.entity.Address;

public interface IAddressService {
	public Address addAddress(Address address);
	public Address editAddress(Address address,Long addressId);
	public String removeAddress(Long addressId);
	public Address getAdderess(Long addressId);
}
