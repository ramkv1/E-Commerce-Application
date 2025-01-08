package com.ecommerce.error.controller;

public class CustomerNotFoundException extends Exception{
	public CustomerNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
