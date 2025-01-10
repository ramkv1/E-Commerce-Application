package com.ecommerce.service;

import com.ecommerce.entity.OrderItem;

public interface IOrderItemService {
	
	OrderItem addOrderItem(OrderItem orderItem);
	OrderItem getOrderItemById(Integer orderItemId);

}
