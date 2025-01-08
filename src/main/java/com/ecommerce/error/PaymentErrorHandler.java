package com.ecommerce.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.error.controller.PaymentNotFoundException;
import com.ecommerce.error.entity.ErrorDetails;

@RestControllerAdvice
public class PaymentErrorHandler {
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleOrderNotFound(PaymentNotFoundException pnfe) {
		System.out.println("PaymentErrorHandler.handleOrderNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), pnfe.getMessage(), "404-Order Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		System.out.println("PaymentErrorHandler.handleAllProblems()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

}
