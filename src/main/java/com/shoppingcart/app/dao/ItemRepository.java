package com.shoppingcart.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}
