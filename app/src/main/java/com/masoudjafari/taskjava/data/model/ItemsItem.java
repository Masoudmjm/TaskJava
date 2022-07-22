package com.masoudjafari.taskjava.data.model;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("title")
	private String title;

	public String getTitle(){
		return title;
	}
}