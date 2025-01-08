package com.ecommerce.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.error.controller.AddressNotFoundException;
import com.ecommerce.error.entity.ErrorDetails;

@RestControllerAdvice
public class AddressErrorHandler {
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleAddressNotFound(AddressNotFoundException anfc) {
		System.out.println("AddressErrorHandler.handleAddressNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), anfc.getMessage(), "404-Address Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		System.out.println("AddressErrorHandler.handleAllProblems()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
}
