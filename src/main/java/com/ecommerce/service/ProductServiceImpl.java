package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.repo.IProductRepository;

@Service("productService")
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductRepository iProductRepository;

	@Override
	public Product createAproduct(Product product) {
		return null;
	}

	@Override
	public Product getProductDetailsById(Integer pid) {
		return iProductRepository.findById(pid).get();
	}

	@Override
	public Product getProductDetails(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
