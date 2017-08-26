package com.shoppingcart.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {
	private String id;
	
	private String itemName;
	
	private String itemDesc;
	
	private Category category;
	
	private boolean available;
	
	private String price;
	
	private Seller sellerInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Seller getSellerInfo() {
		return sellerInfo;
	}

	public void setSellerInfo(Seller sellerInfo) {
		this.sellerInfo = sellerInfo;
	}
	
	
}
