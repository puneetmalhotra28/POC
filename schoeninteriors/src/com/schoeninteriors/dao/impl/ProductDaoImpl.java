package com.schoeninteriors.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoeninteriors.constants.ProductStausConstant;
import com.schoeninteriors.dao.ProductDao;
import com.schoeninteriros.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> viewProducts() {
		Session session = sessionFactory.getCurrentSession();
		String q = "from Product p where p.status=:status";
		Query query = session.createQuery(q);
		query.setParameter("status", ProductStausConstant.ACTIVE);
		if (query.list().size() == 0) {
			return null;
		}
		return (List<Product>) query.list();
	}

	@Override
	public Product addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		return product;
	}

	@Override
	public Product editProduct(String productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, productId);
		return product;
	}
}
