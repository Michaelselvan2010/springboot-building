package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.UserInfo;
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
	public UserInfo createUser(UserInfo userInfo) {
		   return userRepository.save(userInfo);
		
	}
	
	//getUserId
	public Optional<UserInfo> getUserById(Long id) {
		Optional<UserInfo> userInfo= userRepository.findById(id);
		return userInfo;
		
	}
	
	// UpdateUserById
	public UserInfo updateUserById(Long id,UserInfo userInfo) {
		userInfo.setId(id);
		return userRepository.save(userInfo);
	}
	
	//deleteUserById
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	//getUserByUsername
	
	public UserInfo getUserInfoByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
