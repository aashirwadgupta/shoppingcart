package com.shoppingcart.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.app.model.User;

public interface UserRepository extends MongoRepository<User, String>{
}
