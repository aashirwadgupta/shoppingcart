package com.shoppingcart.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Profile;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String>{

}
