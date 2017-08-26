package com.shoppingcart.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dao.ItemRepository;
import com.shoppingcart.app.model.Item;
import com.shoppingcart.app.services.ItemService;

@RestController
public class ItemRestController {

	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="searchItem", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> searchItem(@RequestParam("text") String text){
		return itemService.searchAnItem(text);
	}
	
	@RequestMapping(value="createItem", method = RequestMethod.POST)
	@ResponseBody
	public String createItem(@RequestBody Item item){
		Item createdItem = itemRepo.insert(item);
		return createdItem.getId();
	}
	
	@RequestMapping(value="updateItem", method = RequestMethod.PUT)
	@ResponseBody
	public String updateItem(@RequestBody Item item){
		if(null!=itemRepo.findOne(item.getId())){
			itemRepo.save(item);
			return "Success";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value="getItemDetails", method = RequestMethod.GET)
	public Item getItemDetails(@RequestParam("id") String itemId){
		return itemRepo.findOne(itemId);
	}
}
