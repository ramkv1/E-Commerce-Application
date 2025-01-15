package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Product;
import com.ecommerce.repo.IOrderItemRepository;
import com.ecommerce.repo.IProductRepository;

@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService {

	@Autowired
	private IOrderItemRepository itemRepository;

	@Autowired
	private IProductRepository productRepository;

	@Override
	public OrderItem getOrderItemById(Integer orderItemId) {
		List<Integer> productIds = getProductIdsByOrderItemId(orderItemId);
		return itemRepository.findById(orderItemId).get();
	}

	public List<Integer> getProductIdsByOrderItemId(Integer orderItemId) {
		List<Product> products = productRepository.findByOrderItem_OrderItemId(orderItemId);
		return products.stream().map(Product::getP_Id).toList(); // Collect all product IDs into a list
	}

	@Override
	public OrderItem addOrderItem(OrderItem orderItem) {

		return itemRepository.save(orderItem);
	}

}
