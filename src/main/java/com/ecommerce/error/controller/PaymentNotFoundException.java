package com.ecommerce.error.controller;

public class PaymentNotFoundException extends Exception{
	public PaymentNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
