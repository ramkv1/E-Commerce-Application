package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Address;
import com.ecommerce.service.IAddressService;

@RestController
@RequestMapping("/address")
public class AdderessOperationsController {
	
	@Autowired
	private  IAddressService addressService;
	
	
	@PostMapping(value =  "/add",consumes = "application/json",produces = "application/json")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> SaveAddress(@RequestBody Address address) {
		return new ResponseEntity<String>("Address Added Successfully"+addressService.addAddress(address),HttpStatus.CREATED);
    }
	
	@GetMapping("/get/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> getAddress(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>("Address of Customers"+addressService.getAdderess(id), HttpStatus.OK);
	}
	
	
}
