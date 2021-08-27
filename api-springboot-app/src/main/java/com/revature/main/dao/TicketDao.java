package com.revature.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.main.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

//	Custom query to return all tickets where the user_id matches parameter
	@Query(value = "select t from ticket t where t.user_id = :id")
	public List<Ticket> findByUserId(int id);

}
