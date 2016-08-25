package com.schoeninteriors.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.schoeninteriors.dao.ProductDao;
import com.schoeninteriors.service.ProductService;
import com.schoeninteriros.model.Product;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public List<Product> viewProducts() {
		try {
			return productDao.viewProducts();
		} catch (Exception e) {
			log.error("Exception occured while fetching products information" + e);
			return null;
		}
	}

	@Override
	public Product addProduct(Product product) {
		try {
			log.debug("Adding product" + product);
			return productDao.addProduct(product);
		} catch (Exception e) {
			log.error("Exception occured while adding product products information with product" + product + e);
			return null;
		}
	}

	@Override
	public Product editProduct(String productId) {
		try {
			log.debug("Edit product" + productId);
			return productDao.editProduct(productId);
		} catch (Exception e) {
			log.error("Exception occured while editing product information with product Id" + productId + " Exception"
					+ e);
			return null;
		}
	}

}
