package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.model.UserModel;

public interface UserDAO extends JpaRepository<UserModel, Integer>{
	
	
//	@Query(value="select * from UserModel")
//	public List<UserModel> findAll();
	
	@Query(value="select * from UserModel u where u.username and u.password = :username and :password")
	public UserModel login(@Param("username") String username,@Param("password") String password);

	
	
	
}
