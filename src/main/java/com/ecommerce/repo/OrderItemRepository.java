package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
