package com.shoppingcart.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class Category {
	private String id;
	
	private String categoryMake;
	
	private String subCategory;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryMake() {
		return categoryMake;
	}

	public void setCategoryMake(String categoryMake) {
		this.categoryMake = categoryMake;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	
}
