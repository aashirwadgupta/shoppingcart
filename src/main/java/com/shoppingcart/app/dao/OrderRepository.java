package com.shoppingcart.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.model.Order;

public interface OrderRepository  extends MongoRepository<Order, String>{
}

