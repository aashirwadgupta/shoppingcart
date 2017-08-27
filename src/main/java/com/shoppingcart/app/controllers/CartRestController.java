package com.shoppingcart.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.model.Cart;
import com.shoppingcart.app.model.CartItem;
import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.services.UserService;

@RestController
public class CartRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartRestController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addToCart", method=RequestMethod.PUT)
	@ResponseBody
	public Cart addToCart(@RequestBody CartItem cartItem, @RequestParam("userId") String userId){
		return userService.addToCart(cartItem, userId);
	}
	
	@RequestMapping(value="/getCart", method=RequestMethod.GET)
	@ResponseBody
	public Cart getCart(@RequestParam("userId") String userId){
		LOGGER.info("Fetching cart for user with id as "+userId);
		return userService.getCart(userId);
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.PUT)
	@ResponseBody
	public String checkout(@RequestBody List<Order> ordersList){
		LOGGER.info("Cart checkout with orders "+ordersList);
		return userService.checkoutCart(ordersList);
		
	}
}
