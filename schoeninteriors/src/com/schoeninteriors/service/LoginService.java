package com.schoeninteriors.service;

import org.springframework.stereotype.Service;

import com.schoeninteriros.model.Users;

@Service
public interface LoginService {

	Users loginUser(Users user);
	
	Users getUser(String username);
	
	Users updateUser(Users user);
}
