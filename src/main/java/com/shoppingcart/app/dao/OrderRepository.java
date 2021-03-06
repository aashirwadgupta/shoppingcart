package com.shoppingcart.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.shoppingcart.app.model.Order;

@Repository
public interface OrderRepository  extends MongoRepository<Order, String>{
}

