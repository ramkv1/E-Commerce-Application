package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Orders;
import com.ecommerce.repo.OrdersRepository;

@Service("orderService")
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders createOrder(Orders order) {
		return ordersRepository.save(order);
	}

	@Override
	public Orders getOrderById(Integer orderId) {
		return ordersRepository.findById(orderId).get();
	}

}
