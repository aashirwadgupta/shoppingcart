package com.shoppingcart.app.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dao.UserRepository;
import com.shoppingcart.app.model.Cart;
import com.shoppingcart.app.model.CartItem;
import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.model.Profile;
import com.shoppingcart.app.model.User;


@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepo;
	
	public Cart addToCart(CartItem cartItem, String userId) {
		User user = userRepo.findOne(userId);
		if(null!= user){
			Cart cart = user.getCart();
			Map<String, CartItem> cartItemMap = null;
			if(null!=cart){
				cartItemMap = cart.getItemMap();
				if(null!=cartItemMap){
					cartItemMap.put(cartItem.getItem().getId(), cartItem);
					cart.setItemMap(cartItemMap);
				} else {
					cartItemMap = new HashMap<String, CartItem>();
					cartItemMap.put(cartItem.getItem().getId(), cartItem);
					cart.setItemMap(cartItemMap);
				}
			} else {
				cart = new Cart();
				cartItemMap = new HashMap<String, CartItem>();
				cartItemMap.put(cartItem.getItem().getId(), cartItem);		
				cart.setItemMap(cartItemMap);
			}
			try{
				user.setCart(cart);
				userRepo.save(user);
				return user.getCart();
			} catch(Exception e){
				LOGGER.error("Exception occured on adding to cart "+e.getMessage());
				return null;
			}
		} else {
			LOGGER.error("User not found for "+userId);
			return null;
		}
	}

	public String updateAddress(String address, String userId, String addressType) {
		User user = userRepo.findOne(userId);
		if(null!= user){
			Profile profile = user.getProfile();
			Map<String, String> addressMap = profile.getAddress();
			addressMap.put(addressType, address);
			profile.setAddress(addressMap);
			user.setProfile(profile);
			try{
				userRepo.save(user);
				return "Success";
			} catch(Exception e){
				return "Error";
			}
		} else {
			return "Error : User not found for "+userId;
		}
	}

	public String checkoutCart(List<Order> ordersList) {
		String userId = ordersList.get(0).getUserId();
		User user = userRepo.findOne(userId);
		List<Order> orderList = user.getOrders();
		orderList.addAll(ordersList);
		user.setOrders(orderList);
		user.setCart(null);
		try{
			userRepo.save(user);
			return "Success";
		} catch(Exception e){
			return "Error : due to "+e.getMessage();
		}
	}

	public Cart getCart(String userId) {
		User user = userRepo.findOne(userId);
		if(null!= user){
			return user.getCart();
		} else {
			return null;
		}
	}

}
