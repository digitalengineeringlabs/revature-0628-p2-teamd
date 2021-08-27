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

import com.revature.main.dao.TicketDao;
import com.revature.main.model.Ticket;

@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions
public class TicketManagerImpl implements TicketManager {

	@Autowired
	private TicketDao dao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<Ticket> findAll() {

//		return dao.findByGenderAndAge("M",31);
//		return dao.getEmployeesWithMedian(40000,50000);
	//	return dao.getSeniorEmployees(30);

		return StreamSupport.stream(dao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public List<Ticket> findAll(int startIndex, int count) {

		Pageable pageable = PageRequest.of(startIndex, count);

		return StreamSupport.stream(dao.findAll(pageable).spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public List<Ticket> findByUserId(int id) {
		return dao.findByUserId(Integer.valueOf(id));
	}

	@Override
	public Ticket findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW) // override when the																					// transaction should																// rollback.
	public Ticket create(Ticket t) {
		return dao.save(t);
		
	}

}
