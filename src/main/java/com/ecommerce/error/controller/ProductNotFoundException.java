package com.ecommerce.error.controller;

public class ProductNotFoundException extends Exception{
	public ProductNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
