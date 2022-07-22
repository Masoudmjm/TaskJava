package com.masoudjafari.taskjava.data.model;

import com.google.gson.annotations.SerializedName;

public class PosterImage{

	@SerializedName("path")
	private String path;

	public String getPath(){
		return path;
	}
}