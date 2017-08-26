package com.shoppingcart.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dao.ProfileRepository;
import com.shoppingcart.app.dao.UserRepository;
import com.shoppingcart.app.model.Profile;
import com.shoppingcart.app.model.User;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public String createProfile(Profile profile){
		try{
			if(null == profileRepo.findOne(profile.getMailId())){
				Profile createdProfile = profileRepo.insert(profile);
				User user = new User();
				user.setId(profile.getMailId());
				user.setProfile(createdProfile);
				userRepo.insert(user);
				return "Success";
			} else {
				return "Error: Duplicate mail Id";
			}
		} catch(Exception e){
			return "Profile Creation failed as "+e.getMessage();
		}
	}

	public String updateProfile(Profile profileObj) {
		try{
			if(null != profileRepo.findOne(profileObj.getMailId())){
				profileRepo.save(profileObj);
				return "Success";
			} else {
				return "Error: Mail Id for the Profile Doesn't Exists!";
			}
		} catch(Exception e){
			return "Error: Profile Update failed as "+e.getMessage();
		}
	}
}
