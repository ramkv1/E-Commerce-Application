package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.Customer;
import com.ecommerce.service.I.IAddressService;
import com.ecommerce.service.I.ICustomerService;

@RestController
@RequestMapping("/address")
public class AddressController {

	private final IAddressService addressService;
	private final ICustomerService customerService;

	
	public AddressController(IAddressService addressService, ICustomerService customerService) {
		this.addressService = addressService;
		this.customerService = customerService;
	}

	@PostMapping("/add")
	public ResponseEntity<String> SaveAddress(@RequestBody Address address) {
//	return new ResponseEntity<String>("Address Added Successfully"+addressService.addAddress(address),HttpStatus.CREATED);
		Customer customer = customerService.getCustomer(address.getCustomer().getCustomerId());
		// Associate the child entity (Address) with the parent (Customer)
		address.setCustomer(customer);
		// Save the address
		addressService.addAddress(address);
		return new ResponseEntity<String>("Address Details are added",
				HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<String> getAddress(@PathVariable Long id) {
		return new ResponseEntity<String>("" + addressService.getAdderess(id), HttpStatus.OK);
	}

}
