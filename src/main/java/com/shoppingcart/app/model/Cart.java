package com.shoppingcart.app.model;

import java.util.Date;
import java.util.Map;

public class Cart {
	
	private Date addedOn;
	
	private Map<String, CartItem> itemMap;
	
	private String cartAmount;

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Map<String, CartItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, CartItem> itemMap) {
		this.itemMap = itemMap;
	}

	public String getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(String cartAmount) {
		this.cartAmount = cartAmount;
	}
	
}
