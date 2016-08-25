package com.schoeninteriors.dao.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoeninteriors.dao.RegisterDao;
import com.schoeninteriros.model.Users;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Users registerUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		user.setCreatedOn(new Date());
		session.save(user);
		return user;
	}
}
