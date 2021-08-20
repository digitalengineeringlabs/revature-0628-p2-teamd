package com.revature.main.manager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.main.dao.UserDAO;
import com.revature.main.model.UserModel;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO dao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<UserModel> findAll(int startIndex, int count) {

		Pageable pageable = PageRequest.of(startIndex, count);

		return StreamSupport.stream(dao.findAll(pageable).spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public UserModel findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)
	public UserModel create(UserModel user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)
	public UserModel delete(UserModel user) {
		// deletes user from DB
		dao.delete(user);
		return user;
	}

//	@Override
//	public UserModel login(String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public UserModel login(String username, String password) {
//		// TODO Auto-generated method stub
//		return dao.login(username, password);
//	}

}
