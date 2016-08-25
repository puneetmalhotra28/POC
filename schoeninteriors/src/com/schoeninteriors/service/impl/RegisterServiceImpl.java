package com.schoeninteriors.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.schoeninteriors.constants.Constants;
import com.schoeninteriors.dao.RegisterDao;
import com.schoeninteriors.service.RegisterService;
import com.schoeninteriros.model.Users;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public Users registerUser(Users user) {
		user.setUserType(Constants.EXTERNAL);
		return registerDao.registerUser(user);
	}

}
