package com.schoeninteriors.dao.impl;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoeninteriors.dao.LoginDao;
import com.schoeninteriros.model.Users;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Users loginUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		String q = "from Users u where u.username=:username and u.password=:password";
		Query query = session.createQuery(q);
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		if (query.list().size() == 0) {
			return null;
		}
		return (Users) query.list().get(0);
	}

	@Override
	public Users getUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		String q = "from Users u where u.username=:username";
		Query query = session.createQuery(q);
		query.setParameter("username", username);
		if (query.list().size() == 0) {
			return null;
		}
		return (Users) query.list().get(0);
	}

	@Override
	public Users updateUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		user.setModifiedOn(new Date());
		session.update(user);
		return user;
	}

}
