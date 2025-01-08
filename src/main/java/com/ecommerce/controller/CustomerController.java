package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<String>("Customer Creates Successfully"+customerService.createCustomer(customer),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get/{cid}")
	public ResponseEntity<String> getCustDetails(@PathVariable Integer cid) {
		return new ResponseEntity<String>("Cust Details are-->"+customerService.getCustomer(cid),HttpStatus.OK);
		
	}

}
