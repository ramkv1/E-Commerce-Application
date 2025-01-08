package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.service.I.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final IProductService productService;
	
	

	public ProductController(IProductService productService) {
		this.productService = productService;
	}



	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(Product product) {
		return new ResponseEntity<String>("Product is save" + productService.saveProduct(product), HttpStatus.CREATED);
	}

}
