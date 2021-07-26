package com.stacksimplify.restservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController 
public class HelloWorldController {

	
	//Simple Method 
	// Testing
	// URI -/helloworld
	//GET 
	//@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("/helloworld2")
	public String helloWorld() {
		return "Hello World2";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		
		return new UserDetails("Kalyan","Reddy","Hyderabad");
	}
}