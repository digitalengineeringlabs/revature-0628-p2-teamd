package com.revature.main.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.main.manager.TicketManager;
import com.revature.main.model.Ticket;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(path = "/tickets")
public class TicketController {

	
	private static final Logger log = LoggerFactory.getLogger(TicketController.class);


	@Autowired
	private TicketManager manager;
	
//	 Finds all entries in DB
	@GetMapping(produces = "application/json")
	public List<Ticket> getAllTickets() {
		return manager.findAll();
	}
	
//	Finds tickets by user_id
	@GetMapping(path = "/{id}", produces = "application/json")
	public List<Ticket> getTickets(@PathVariable int id) {
		return manager.findByUserId(id);
	}
	
//	Updates tickets based on URL and user input
	@PatchMapping(path = "/{id}", produces = "application/json")
	public Ticket upDateTicket(@PathVariable int id,@Valid @RequestBody Ticket ticket) throws ConfigDataResourceNotFoundException{
		Ticket ticket1 = manager.findById(id);
		ticket1.setReason(ticket.getReason());
		ticket1.setAmount(ticket.getAmount());
		ticket1.setStatus(ticket.getStatus());
		ticket1.setTime(new Date());
		ticket1.setUser_id(ticket.getUser_id());
		final Ticket upDatedTicket = manager.create(ticket1);
		return upDatedTicket;
	}

//	Creates a ticket using URL for user_id and entered information
	@PostMapping(path = "/create/{id}", consumes = "application/json", produces = "application/json")
	public Ticket create(@Valid @RequestBody Ticket ticket) {
		return manager.create(ticket);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		for(Map.Entry<String, String> error : errors.entrySet()) {
			log.info(error.getKey() + " " + error.getValue());
		}
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolationExceptions(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getCause().getLocalizedMessage());
		for(Map.Entry<String, String> error : errors.entrySet()) {
			log.info(error.getKey() + " " + error.getValue());
		}
		return errors;
	}

}
