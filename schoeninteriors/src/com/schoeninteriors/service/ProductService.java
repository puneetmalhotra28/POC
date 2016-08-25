package com.schoeninteriors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoeninteriros.model.Product;

@Service
public interface ProductService {

	public List<Product> viewProducts();
	public Product addProduct(Product product);
	public Product editProduct(String productId);
}
