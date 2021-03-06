package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

// Entity

@Entity
@Table(name="user1")
//@JsonIgnoreProperties({"firstname","lastname"})  -- Static Filtering @JsonIgnore

//@JsonFilter(value="userFilter")     -- Used for MappingJacksonValue filtering section

public class UserInfo{
    @Id
    @GeneratedValue
    @JsonView(Views.External.class)
    private Long id;
     
    @NotEmpty(message ="Username is Mandatory field. Please provide username")
    @Column(name="USER_NAME",length=50,nullable=false,unique=true)
    @JsonView(Views.External.class)
	private String username;

    @Size(min=2,message="FirstName should have atleast 2 character")
    @Column(name="FIRST_NAME",length=50,nullable=false)
    @JsonView(Views.External.class)
	private String firstname;
    
    @Column(name="LAST_NAME",length=50,nullable=false)
    @JsonView(Views.External.class)
	private String lastname;
	
    @Column(name="EMAIL_ADDRESS",length=50,nullable=false)
    @JsonView(Views.External.class)
	private String email;
    
    @Column(name="ROLE",length=50,nullable=false)
    @JsonView(Views.Internal.class)
	private String role;
	
   // @JsonIgnore  -- Static Filtering @JsonIgnore
	@Column(name="SSN",length=50,nullable=false,unique=true)
	@JsonView(Views.Internal.class)
	private String ssn;

	
	@OneToMany(mappedBy="userInfo")
	@JsonView(Views.Internal.class)
	private List<Order> order;
	
	
	
	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

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
