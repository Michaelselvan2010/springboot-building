package com.stacksimplify.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// Entity

@Entity
@Table(name="user1")
public class UserInfo {
    @Id
    @GeneratedValue
	private Long id;
    
    @Column(name="USER_NAME",length=50,nullable=false,unique=true)
	private String username;
    
    @Column(name="FIRST_NAME",length=50,nullable=false)
	private String firstname;
    
    @Column(name="LAST_NAME",length=50,nullable=false)
	private String lastname;
	
    @Column(name="EMAIL_ADDRESS",length=50,nullable=false)
	private String email;
    
    @Column(name="ROLE",length=50,nullable=false)
	private String role;
	
	@Column(name="SSN",length=50,nullable=false,unique=true)
	private String ssn;

	// No Argument Constructor
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * CREATE TABLE USER(ID LONG,USER_NAME VARCHAR(100),FIRST_NAME
	 * VARCHAR(100),LAST_NAME VARCHAR(100),EMAIL_ADDRESS VARCHAR(100),ROLE
	 * VARCHAR(100),SSN VARCHAR(100));
	 * 
	 * 
	 * DROP TABLE USER;
	 * 
	 * INSERT INTO USER
	 * VALUES(101,'ADMIN','MICHAEL','SELVAN','MICHAEL.SELVAN2005@GMAIL.COM','
	 */	// Field Constructor
	
	public UserInfo(Long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	
	// Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	// To String

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
