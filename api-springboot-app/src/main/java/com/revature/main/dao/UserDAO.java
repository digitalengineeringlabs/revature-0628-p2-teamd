package com.revature.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.main.model.UserModel;

public interface UserDAO extends JpaRepository<UserModel, Integer>{
	
	
	
	public List<UserModel> findAll();
	
//	Custom query to login, finds user in db by username and password, then returns user if found.
	@Query(value="select u from UserModel u where u.username = :username and u.password = :password")
	public UserModel findByUserNameAndPassword( @Param("username") String username, @Param("password") String password);
}
