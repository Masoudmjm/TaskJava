package com.masoudjafari.taskjava.data.model;

import com.google.gson.annotations.SerializedName;

public class CoverImage{

	@SerializedName("path")
	private String path;

	public String getPath(){
		return path;
	}
}