package com.revature.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.manager.UserManager;
import com.revature.model.UserModel;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserManager manager;
	
	@GetMapping(path="/login", produces="application/json")
	public UserModel login(String username, String password) {
		return manager.login(username, password);
	}
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public UserModel create(@Valid @RequestBody UserModel user) {
		return manager.create(user);
	}

}
