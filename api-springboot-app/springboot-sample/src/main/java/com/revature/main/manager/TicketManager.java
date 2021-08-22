package com.revature.main.manager;

import java.util.List;

import com.revature.main.model.Ticket;

public interface TicketManager {

	List<Ticket> findAll();

	List<Ticket> findAll(int startIndex, int count);

	Ticket findById(int id);

	Ticket create(Ticket t);

}
