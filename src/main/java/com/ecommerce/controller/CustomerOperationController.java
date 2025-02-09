package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Customer;
import com.ecommerce.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerOperationController {
	
	private final ICustomerService customerService;
	
	CustomerOperationController(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping(value ="/create", consumes = "application/json", produces = "application/json")
    @PreAuthorize("isAuthenticated()") // Ensure the user is authenticated
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping(value ="/get/{id}")
    @PreAuthorize("isAuthenticated()") // Ensure the user is authenticated
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer cid) {
		return new ResponseEntity<Customer>(customerService.getCustomer(cid), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCustomer/{name}")
    @PreAuthorize("isAuthenticated()") // Ensure the user is authenticated
	public ResponseEntity<String> getCustomerByname(@PathVariable("name") String name){
		return new ResponseEntity<String>("Customer Id--->"+customerService.getCustomerByCustometName(name),HttpStatus.OK);
	}

}
