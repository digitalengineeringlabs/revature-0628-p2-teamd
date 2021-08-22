package com.revature.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.main.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

	//@Query(value = "select t from Ticket t where t.amount between :start and :end")
//	public List<Ticket> getEmployeesWithMedian(@Param("start") int start, @Param("end") int end);

	//@Query(value = "select * from ticket where id > ?1", nativeQuery = true)
//	public List<Ticket> getSeniorEmployees(int limit);

}
