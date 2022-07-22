package com.masoudjafari.taskjava.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CategoriesItem{

	@SerializedName("type")
	private String type;

	@SerializedName("items")
	private List<ItemsItem> items;

	public String getType(){
		return type;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}