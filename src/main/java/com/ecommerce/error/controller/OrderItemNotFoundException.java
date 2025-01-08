package com.ecommerce.error.controller;

public class OrderItemNotFoundException extends Exception{
	public OrderItemNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
