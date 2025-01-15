package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer>{
	
}
