package com.shoppingcart.app.model;

import java.util.Date;

public class WishList {
	
	private Date addedOn;
	
	private Item item;

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
