package com.shoppingcart.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.model.User;

public interface UserRepository extends MongoRepository<User, String>{
}
