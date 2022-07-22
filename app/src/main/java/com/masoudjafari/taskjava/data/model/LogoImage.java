package com.masoudjafari.taskjava.data.model;

import com.google.gson.annotations.SerializedName;

public class LogoImage{

	@SerializedName("path")
	private String path;

	public String getPath(){
		return path;
	}
}