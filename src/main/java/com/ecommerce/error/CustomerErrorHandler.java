package com.ecommerce.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.error.controller.CustomerNotFoundException;
import com.ecommerce.error.entity.ErrorDetails;

@RestControllerAdvice
public class CustomerErrorHandler {
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCustomerNotFound(CustomerNotFoundException cnfe){
		System.out.println("CustomerErrorHandler.handleCustomerNotFound()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),cnfe.getMessage(),"404-Customer Not Found");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
		System.out.println("CustomerErrorHandler.handleAllProblems()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),e.getMessage(),"problem in execution");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
}
