package com.shoppingcart.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.app.model.Order;

public interface OrderRepository  extends MongoRepository<Order, String>{
}

