package com.stacksimplify.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.UserInfo;
import com.stacksimplify.restservices.services.UserService;

@RestController
public class UserController {

	// Autowire teh UserService
	
	@Autowired
	private UserService userService;
	
	//getAllUsers Method
	@GetMapping("/users")
	public List<UserInfo> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	// Create User
	//@RequestBody Annotation
	//@PostMapping Annotation
	
	@PostMapping("/users")
	public UserInfo createUser(@RequestBody UserInfo userInfo) {
		return userService.createUser(userInfo);
	}
	
	//getUserById
	
	/*
	 * public Optional<UserInfo> getUserById(@PathVariable("id") Long id){ return
	 * userService.getUserById(id); }
	 */
	@GetMapping("/users/{id}")
	public java.util.Optional<UserInfo> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
	}
	
	
	//updateUserById
	@PutMapping("/users/{id}")
	public UserInfo updateUserById(@PathVariable("id") Long id,
			@RequestBody UserInfo userInfo) {
		return userService.updateUserById(id, userInfo);
	}
	
	
	//deleteUserById
	@DeleteMapping("/users/{id}")
	public void deleteUseById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	
	//getuserBuUsername
	@GetMapping("/users/byusername/{username}")
	public UserInfo getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserInfoByUsername(username);
		
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
