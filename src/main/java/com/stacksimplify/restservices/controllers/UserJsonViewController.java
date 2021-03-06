package com.stacksimplify.restservices.controllers;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restservices.entities.UserInfo;
import com.stacksimplify.restservices.entities.Views;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

@RestController
@Validated
@RequestMapping(value="/jsonview/users")

public class UserJsonViewController {
	
	@Autowired
	private UserService userService;
	@JsonView(Views.External.class)
	@GetMapping("/external/{id}")
	public java.util.Optional<UserInfo> getUserById(@PathVariable("id") @Min(1) Long id){
		
		try {
			return userService.getUserById(id);
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
		}
	}
	
	@GetMapping("/internal/{id}")
	@JsonView(Views.Internal.class)
	public java.util.Optional<UserInfo> getUserById2(@PathVariable("id") @Min(1) Long id){
		
		try {
			return userService.getUserById(id);
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
		}
	}
	
}
