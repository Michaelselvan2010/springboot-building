package com.stacksimplify.restservices;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController 
public class HelloWorldController {

	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	
	
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
	

	@GetMapping("/hello-int")
	public String getMessageInI18NFormat(@RequestHeader(name="Accept-Language",required=false) String locale) {
		return messageSource.getMessage("label.hello",null,new Locale(locale));
	}
	
	
	
	
	
}
