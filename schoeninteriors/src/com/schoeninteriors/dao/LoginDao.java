package com.schoeninteriors.dao;

import org.springframework.stereotype.Repository;

import com.schoeninteriros.model.Users;

@Repository
public interface LoginDao {

	Users loginUser(Users user);
	Users getUser(String username);
	Users updateUser(Users user);
}
