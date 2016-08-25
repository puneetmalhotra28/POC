package com.schoeninteriors.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoeninteriros.model.Product;

@Repository
public interface ProductDao {

	public List<Product> viewProducts();
	public Product addProduct(Product product);
	public Product editProduct(String productId);
}
