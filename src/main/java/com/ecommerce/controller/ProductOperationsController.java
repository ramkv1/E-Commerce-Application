package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductOperationsController {
	
	private final IProductService iProductService;
	
	public ProductOperationsController(IProductService productService) {
		this.iProductService=productService;
	}
	
	@PostMapping(value = "/addProduct",consumes ="application/json", produces = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(iProductService.createAproduct(product),HttpStatus.CREATED);		
	}
	

}
