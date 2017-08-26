package com.shoppingcart.app.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	private String id;

	private Profile profile;

	private List<Order> orders;

	private Map<String, Reviews> reviews;
	
	private List<Payment> paymentInfo;
	
	private List<WishList> wishList;
	
	private List<Cart> cart;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Map<String, Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Map<String, Reviews> reviews) {
		this.reviews = reviews;
	}

	public List<Payment> getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(List<Payment> paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public List<WishList> getWishList() {
		return wishList;
	}

	public void setWishList(List<WishList> wishList) {
		this.wishList = wishList;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	
}
