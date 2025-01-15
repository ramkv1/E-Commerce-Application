package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Orders;

public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

}
