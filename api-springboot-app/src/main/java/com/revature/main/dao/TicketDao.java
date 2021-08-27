package com.revature.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.main.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

	//@Query(value = "select t from Ticket t where t.amount between :start and :end")
//	public List<Ticket> getEmployeesWithMedian(@Param("start") int start, @Param("end") int end);

	@Query(value = "select t from ticket t where t.user_id = :limit")
	public List<Ticket> findByUserId(int limit);

}
