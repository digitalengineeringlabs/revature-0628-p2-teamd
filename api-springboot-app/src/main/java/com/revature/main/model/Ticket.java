package com.revature.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
	private int id;
	@Column(name= "reason")
	private String reason;
	@Column(name="amount")
	private double amount;
	@Column(name="status")
	private String status = "Pending";
	@Column(name="time")
	private Date time;
	@Column(name="user_id")
	private int user_id;

	public Ticket() {
		super();
	}
	
	public Ticket(String reason, double amount, Date time, int user_id) {
		super();
		this.reason = reason;
		this.amount = amount;
		this.time = time;
		this.user_id = user_id;
	}

	public Ticket(int id, String reason, double amount, String status,Date time, int user_id) {
		super();
		this.id = id;
		this.reason = reason;
		this.amount = amount;
		this.status = status;
		this.time = time;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
}
