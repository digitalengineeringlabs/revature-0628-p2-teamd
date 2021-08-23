package com.revature.main.manager;

import java.util.List;

import com.revature.main.model.UserModel;

public interface UserManager {

	List<UserModel> findAll();

	List<UserModel> findAll(int startIndex, int count);

	UserModel findById(int id);

	UserModel create(UserModel user);
	
	UserModel delete(UserModel user);
	
	UserModel findByUserNameAndPassword(UserModel user);
}
