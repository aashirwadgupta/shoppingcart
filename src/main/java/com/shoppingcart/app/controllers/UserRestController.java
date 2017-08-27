package com.shoppingcart.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dao.UserRepository;
import com.shoppingcart.app.model.User;
import com.shoppingcart.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
	@Autowired
	private UserRepository userRepo; 
	
	@Autowired 
	private UserService userService;
	
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
	
	@RequestMapping(value="/getUser", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@RequestParam("userId") String userId){
		LOGGER.info("Fetching user with "+userId);
		return userRepo.findOne(userId);
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestBody User user){
		try{
			User createdUser = userRepo.insert(user);
			return "User created with id as "+createdUser.getId();
		} catch(Exception e) {
			return "User creation failed with an exception as "+e.getMessage();
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String doLogin(@RequestParam("username") String userName, @RequestParam("password") String password){
		return "";
	}
	
	@RequestMapping(value="/addAddress", method = RequestMethod.POST)
	@ResponseBody
	public String addAddress(@RequestBody String address, @RequestParam("userId") String userId, @RequestParam("type") String addressType){
		return userService.updateAddress(address, userId, addressType);
	}

}
