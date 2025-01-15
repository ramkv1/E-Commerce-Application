package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{
	
	// Fetch product by order item ID
    List<Product> findByOrderItem_OrderItemId(Integer orderItemId);

}
