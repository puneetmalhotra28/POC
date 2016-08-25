package com.schoeninteriors.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.schoeninteriors.dao.LoginDao;
import com.schoeninteriors.service.LoginService;
import com.schoeninteriros.model.Users;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public Users loginUser(Users user) {
		return loginDao.loginUser(user);
	}

	@Override
	public Users getUser(String username) {
		return loginDao.getUser(username);
	}

	@Override
	public Users updateUser(Users user) {
		return loginDao.updateUser(user);
	}

}
