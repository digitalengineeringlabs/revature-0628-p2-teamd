package com.revature.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.main.model.UserModel;

public interface UserDAO extends JpaRepository<UserModel, Integer>{
	
	
	
	public List<UserModel> findAll();
	
	@Query(value="select u from UserModel u where u.username = :username and u.password = :password")
	public UserModel findByUserNameAndPassword( @Param("username") String username, @Param("password") String password);

	
	
	
}
