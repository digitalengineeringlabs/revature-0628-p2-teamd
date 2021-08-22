package com.example.demo.manager;

import java.util.List;

import com.example.demo.model.Ticket;

public interface TicketManager {

	List<Ticket> findAll();

	List<Ticket> findAll(int startIndex, int count);

	Ticket findById(int id);

	Ticket create(Ticket t);

}
