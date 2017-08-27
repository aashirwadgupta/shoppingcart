package com.shoppingcart.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Item;

@Service
public class ItemService {
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	public List<Item> searchAnItem(String text){
		return mongoTemplate.find(Query.query(new Criteria()
                .orOperator(Criteria.where("itemDesc").regex(text, "i"),
                        Criteria.where("itemName").regex(text, "i"))
            ), Item.class, "items");
	}
}
