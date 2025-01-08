package com.ecommerce.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.error.controller.OrderNotFoundException;
import com.ecommerce.error.entity.ErrorDetails;

@RestControllerAdvice
public class OrdersErrorHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleOrderNotFound(OrderNotFoundException onfe) {
		System.out.println("OrdersErrorHandler.handleOrderNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), onfe.getMessage(), "404-Order Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		System.out.println("OrdersErrorHandler.handleAllProblems()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
}
