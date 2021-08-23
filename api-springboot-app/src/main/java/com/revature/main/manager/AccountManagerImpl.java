package com.revature.main.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.main.dao.AccountDao;
import com.revature.main.model.Account;

@Service
public class AccountManagerImpl implements AccountManager {

	@Autowired
	private AccountDao dao;
	
	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}

}
