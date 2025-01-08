package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
