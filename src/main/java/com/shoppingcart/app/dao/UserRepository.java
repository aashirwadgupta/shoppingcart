package com.shoppingcart.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
