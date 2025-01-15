package com.ecommerce.service;

import com.ecommerce.entity.OrderItem;
import com.ecommerce.error.controller.ProductNotFoundException;

public interface IOrderItemService {
	
	OrderItem addOrderItem(OrderItem orderItem);
	OrderItem getOrderItemById(Integer orderItemId);
}
