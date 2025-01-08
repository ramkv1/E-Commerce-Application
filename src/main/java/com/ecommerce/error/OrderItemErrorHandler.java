package com.ecommerce.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.error.controller.OrderItemNotFoundException;
import com.ecommerce.error.entity.ErrorDetails;


@RestControllerAdvice
public class OrderItemErrorHandler {
	
	@ExceptionHandler(OrderItemNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleOrderItemNotFound(OrderItemNotFoundException oinfe) {
		System.out.println("OrderItemErrorHandler.handleOrderItemNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), oinfe.getMessage(), "404-OrderItem Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		System.out.println("OrderItemErrorHandler.handleAllProblems()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
}
