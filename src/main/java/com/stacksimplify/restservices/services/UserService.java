package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.UserInfo;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;

//Service
@Service
public class UserService {

	// Autowired the UserRepository
	@Autowired
	private UserRepository userRepository;
	
	// getAllUsers Methods
	public List<UserInfo> getAllUsers(){
		return userRepository.findAll();
	}
	
	//CreateUser Method
	public UserInfo createUser(UserInfo userInfo) throws UserExistsException {
		//if user exists using username
		
		UserInfo existingUser=userRepository.findByUsername(userInfo.getUsername());
		
		// if not exists throw UserExistsException
		
		if(existingUser !=null) {
			throw new UserExistsException("User already exists in repository");
		}
		
		
		
		
		
		   return userRepository.save(userInfo);
		
	}
	
	//getUserId
	public Optional<UserInfo> getUserById(Long id) throws UserNotFoundException {
		Optional<UserInfo> userInfo= userRepository.findById(id);
		
		if(!userInfo.isPresent()) {
			 throw new UserNotFoundException("User Not found in user Repository");
		}
		return userInfo;
		
	}
	
	// UpdateUserById
	public UserInfo updateUserById(Long id,UserInfo userInfo)throws UserNotFoundException {
		
		Optional<UserInfo> optionalUser =userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			 throw new UserNotFoundException("User Not found in user Repository, Provide the correct UserId");
		}
		
		userInfo.setId(id);
		return userRepository.save(userInfo);
	}
	
	//deleteUserById

	public void deleteUserById(Long id) {
	Optional<UserInfo> optionalUser =userRepository.findById(id);
	if(!optionalUser.isPresent()) {
	 throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not found in user Repository, Provide the correct UserId");
	}
	userRepository.deleteById(id);	
	}
	
	//getUserByUsername
	
	public UserInfo getUserInfoByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
