package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.repo.ProductRepository;
import com.ecommerce.service.I.IProductService;


@Service
public class ProductServiceImpl implements IProductService{

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

}
