package com.ecommerce.service;

import com.ecommerce.entity.Product;

public interface IProductService {
	public Product createAproduct(Product product);
	public Product getProductDetailsById(Integer pid);
	public Product getProductDetails(Product product);
}
