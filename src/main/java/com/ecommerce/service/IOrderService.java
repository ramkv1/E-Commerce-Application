package com.ecommerce.service;

import java.util.Optional;

import com.ecommerce.entity.Orders;

public interface IOrderService {

	public Orders createOrder(Orders order);
	public Orders getOrderById(Integer orderId);
}
