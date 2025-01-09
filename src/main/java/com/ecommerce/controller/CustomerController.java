package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Customer;
import com.ecommerce.service.I.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private final ICustomerService customerService;	
	
	
	
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}


	@PostMapping(value ="/create", consumes = "application/json" ,produces = "application/json")
    @PreAuthorize("isAuthenticated()") // Ensure the user is authenticated
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<String>("Customer Creates Successfully"+customerService.createCustomer(customer),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get/{cid}")
    @PreAuthorize("isAuthenticated()") // Ensure the user is authenticated
	public ResponseEntity<String> getCustDetails(@PathVariable Integer cid) {
		return new ResponseEntity<String>("Cust Details are-->"+customerService.getCustomer(cid),HttpStatus.OK);
		
	}

}
