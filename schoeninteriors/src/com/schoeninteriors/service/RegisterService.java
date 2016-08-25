package com.schoeninteriors.service;

import org.springframework.stereotype.Service;

import com.schoeninteriros.model.Users;

@Service
public interface RegisterService {

	
	public Users registerUser(Users user);
}
