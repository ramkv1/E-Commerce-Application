package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.OrderItem;
import com.ecommerce.repo.OrderItemRepository;

@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService{
	
	@Autowired
	private OrderItemRepository itemRepository;

	@Override
	public OrderItem addOrderItem(OrderItem orderItem) {
		return itemRepository.save(orderItem);
	}

	@Override
	public OrderItem getOrderItemById(Integer orderItemId) {
		return itemRepository.findById(orderItemId).get();
	}

}
