package com.ecommerce.error.controller;

public class AddressNotFoundException extends Exception{
	public AddressNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
