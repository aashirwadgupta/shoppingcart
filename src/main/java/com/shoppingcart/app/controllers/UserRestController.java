package com.shoppingcart.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dao.UserRepository;
import com.shoppingcart.app.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserRepository userRepo; 
	
	@RequestMapping(value="/sayHello", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello(){
		return "Hello! I am working";
	}
	
	@RequestMapping(value="/getAllUser", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestBody User user){
		try{
			User createdUser = userRepo.insert(user);
			return "User created with id as "+createdUser.getId();
		} catch(Exception e) {
			return "USer creation failed with an exception as "+e.getMessage();
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String doLogin(@RequestParam("username") String userName, @RequestParam("password") String password){
		return "";
	}

}
