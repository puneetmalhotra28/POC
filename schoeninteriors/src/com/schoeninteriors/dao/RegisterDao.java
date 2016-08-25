package com.schoeninteriors.dao;

import org.springframework.stereotype.Repository;

import com.schoeninteriros.model.Users;

@Repository
public interface RegisterDao {

	public Users registerUser(Users user);
}
