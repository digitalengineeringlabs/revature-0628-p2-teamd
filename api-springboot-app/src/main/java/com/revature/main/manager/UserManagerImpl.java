package com.revature.main.manager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.main.dao.UserDAO;
import com.revature.main.model.UserModel;

import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
public class UserManagerImpl implements UserManager {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserManagerImpl.class);


//	Implementation of UserManager class
	
	@Autowired
	private UserDAO dao;

	
//	Returns all users
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<UserModel> findAll() {
		log.info("Findall called.");
		return dao.findAll();
	}

//	Returns all users within a range by uid
	@Override
	public List<UserModel> findAll(int startIndex, int count) {

		Pageable pageable = PageRequest.of(startIndex, count);
		
		log.info("findAll called with restrictions: start: " + startIndex + " end: " + count);

		return StreamSupport.stream(dao.findAll(pageable).spliterator(), false).collect(Collectors.toList());
	}
	
//  Returns a specific user by uid
	@Override
	public UserModel findById(int id) {
		log.info("findByID called, restrictions: " + id);
		return dao.findById(Integer.valueOf(id)).get();
	}
	
//	Basic login function, returns user by username and password
	@Override
	public UserModel findByUserNameAndPassword(UserModel user) {
		log.info("login attempted by: " + user.getUsername());
		return dao.findByUserNameAndPassword( user.getUsername(), user.getPassword());
	}

//	Persists the user in the database, serializable with rollback for fails.
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)
	public UserModel create(UserModel user) {
		log.info("Persisting: " + user.toString());
		return dao.save(user);
	}

//	 deletes user from DB, serializable with rollback for fails.
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)
	public UserModel delete(UserModel user) {
		log.info("Deleting: " + user.toString());
		dao.delete(user);
		return user;
	}

}
