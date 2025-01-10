package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.OrderItem;
import com.ecommerce.service.IOrderItemService;

@RestController
@RequestMapping("/orderItem")
public class OrderItemOperationsController {
	
	@Autowired
	private IOrderItemService iOrderItemService;
	
	
	@PostMapping(value =  "/createItem" ,consumes = "application/json", produces = "application/json")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<OrderItem> createOrders(@RequestBody OrderItem orderItem){
		return new ResponseEntity<OrderItem>(iOrderItemService.addOrderItem(orderItem),HttpStatus.CREATED);
	}
	
	@GetMapping("/getOrder/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<OrderItem> findOrderItemById(@PathVariable("id") Integer oIid){
		return new ResponseEntity<OrderItem>(iOrderItemService.getOrderItemById(oIid),HttpStatus.OK);
	}

}
