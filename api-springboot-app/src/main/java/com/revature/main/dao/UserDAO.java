package com.revature.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.main.model.UserModel;

public interface UserDAO extends JpaRepository<UserModel, Integer>{
	
	
	
	public List<UserModel> findAll();
	
//	@Query(value="select all from UserModel u where u.username and u.password = :username and :password")
//	public UserModel login(@Param("username") String username,@Param("password") String password);

	
	
	
}
