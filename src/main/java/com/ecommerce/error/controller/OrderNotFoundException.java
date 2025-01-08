package com.ecommerce.error.controller;

public class OrderNotFoundException extends Exception{
	public OrderNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
