package com.stacksimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stacksimplify.restservices.entities.UserInfo;

// Repositort
@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {

	
	 UserInfo findByUsername(String username);
		 
	
	
}
