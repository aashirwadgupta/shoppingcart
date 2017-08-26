package com.shoppingcart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@RequestMapping(value="/sayHello", method = RequestMethod.GET)
	public String sayHello(){
		return "Hello! I am working";
	}

}
