package com.shoppingcart.app.controllers;

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
import com.shoppingcart.app.model.Profile;
import com.shoppingcart.app.services.ProfileService;

@RestController
public class ProfileRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileRestController.class);
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value="/createProfile", method=RequestMethod.POST)
	public String createProfile(@RequestBody Profile profileObj){
		return profileService.createProfile(profileObj);
	}
	
	@RequestMapping(value="/getProfile", method=RequestMethod.GET)
	@ResponseBody
	public Profile getProfile(@RequestParam("email") String emailId){
		LOGGER.info("Fetching Profile of "+emailId);
		return userRepo.findOne(emailId).getProfile();
	}
	
	@RequestMapping(value="/updateProfile", method=RequestMethod.PUT)
	public String updateProfile(@RequestBody Profile profileObj){
		return profileService.updateProfile(profileObj);
	}
	
	
}
