package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
