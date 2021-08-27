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

import com.revature.main.dao.TicketDao;
import com.revature.main.model.Ticket;

import lombok.extern.java.Log;

@Log
@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions
public class TicketManagerImpl implements TicketManager {

	private static final Logger log = LoggerFactory.getLogger(TicketManagerImpl.class);

	@Autowired
	private TicketDao dao;

//	Finds all tickets in DB
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<Ticket> findAll() {
		log.info("findAll called");
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}

//	Finds all tickets from start index plus count
	@Override
	public List<Ticket> findAll(int startIndex, int count) {

		Pageable pageable = PageRequest.of(startIndex, count);
		log.info("findAll starting with " + startIndex + "and count " + count);
		return StreamSupport.stream(dao.findAll(pageable).spliterator(), false).collect(Collectors.toList());
	}

//	Finds by user_id the totally of tickets submitted by them
	@Override
	public List<Ticket> findByUserId(int id) {
		return dao.findByUserId(Integer.valueOf(id));
	}

//	Finds single ticket with the id of id
	@Override
	public Ticket findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}

//	Persists ticket in the DB
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW) 
	public Ticket create(Ticket t) {
		log.debug(t.toString());
		return dao.save(t);
	}

}
