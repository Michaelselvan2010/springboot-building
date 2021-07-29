package com.stacksimplify.restservices.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stacksimplify.restservices.entities.UserInfo;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Api(tags="User Management RESTful Services", value="UserController",description="Controller for User Managemnt Service")
@RestController
@Validated
public class UserController {

	// Autowire teh UserService
	
	@Autowired
	private UserService userService;
	
	//getAllUsers Method
	
	@ApiOperation(value ="Retrive list of Users")
	@GetMapping("/users")
	public List<UserInfo> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	// Create User
	//@RequestBody Annotation
	//@PostMapping Annotation
	@ApiOperation(value ="Create new  Users")
	@PostMapping("/users")
	public ResponseEntity<Void> createUser(@Valid @RequestBody UserInfo userInfo,UriComponentsBuilder builder) {
		
		try {
			
		userService.createUser(userInfo);
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setLocation(builder.path("/users/{id}").buildAndExpand(userInfo.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		
		}catch(UserExistsException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
		}
		
	}
	
	//getUserById
	
	/*
	 * public Optional<UserInfo> getUserById(@PathVariable("id") Long id){ return
	 * userService.getUserById(id); }
	 */
	@GetMapping("/users/{id}")
	public java.util.Optional<UserInfo> getUserById(@PathVariable("id") @Min(1) Long id){
		
		try {
			return userService.getUserById(id);
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
		}
	}
	
	
	//updateUserById
	@PutMapping("/users/{id}")
	public UserInfo updateUserById(@PathVariable("id") Long id,
			@RequestBody UserInfo userInfo) {
		
		try {
		return userService.updateUserById(id, userInfo);
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
		}
	}
	
	
	//deleteUserById
	@DeleteMapping("/users/{id}")
	public void deleteUseById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	
	//getuserBuUsername
	@GetMapping("/users/byusername/{username}")
	public UserInfo getUserByUsername(@PathVariable("username") String username) throws UserNameNotFoundException {
		UserInfo userInfo= userService.getUserInfoByUsername(username);
		if(userInfo ==null)
		   throw new UserNameNotFoundException("Username: '"+username+"' Not found in User Repository");
		return userInfo;
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
