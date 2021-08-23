package com.revature.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.main.manager.UserManager;
import com.revature.main.model.UserModel;

@RestController
@RequestMapping(path = "users")
public class UserController {
	
	@Autowired
	private UserManager manager;
	
	@ResponseBody
	@GetMapping(path="/login", consumes = "application/json", produces="application/json")
	public UserModel findByUserNameAndPassword(@RequestBody UserModel user) {
		System.out.println("login attempted");
		System.out.println(user);
		return manager.findByUserNameAndPassword(user);
	}
	
	@PostMapping(path = "/create", consumes = "application/json")
	public UserModel create(@Valid @RequestBody UserModel user) {
		return manager.create(user);
	}
	
	@GetMapping(path = "/all", produces = "application/json")
	public List<UserModel> getAllUsers(){
		return manager.findAll();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolationExceptions(
			ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	    errors.put("message",ex.getCause().getLocalizedMessage());
	    return errors;
	}


}
