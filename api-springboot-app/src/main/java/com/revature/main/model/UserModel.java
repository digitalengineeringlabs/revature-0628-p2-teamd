package com.revature.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user_table")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "user_table_uid_seq", allocationSize = 1)
	private int uid;
	@Column(name = "first_name")
	@NotNull(message = "First Name is Required")
	private String firstName;
	@Column(name = "last_name")
	@NotNull(message = "Last Name is Required")
	private String lastName;
	@Column(name = "phone_number")
	private int phoneNumber;
	@Column
	private String email;
	@Column(name = "employee_type")
	private String employeeType;
	@Column(name = "user_name")
	@NotNull(message = "Username is Required")
	private String username;
	@Column
	@NotNull(message = "Password is Required")
	private String password;
	
	
	public UserModel() {
		super();
	}
	
	public UserModel(@NotNull(message = "First Name is Required") String firstName,
			@NotNull(message = "Last Name is Required") String lastName,
			@NotNull(message = "Username is Required") String username,
			@NotNull(message = "Password is Required") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public UserModel(int uid, @NotNull(message = "First Name is Required") String firstName,
			@NotNull(message = "Last Name is Required") String lastName, int phoneNumber, String email,
			String employeeType, @NotNull(message = "Username is Required") String username,
			@NotNull(message = "Password is Required") String password) {
		super();
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.employeeType = employeeType;
		this.username = username;
		this.password = password;
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
