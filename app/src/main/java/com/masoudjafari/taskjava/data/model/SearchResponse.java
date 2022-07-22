package com.masoudjafari.taskjava.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("meta")
	private Meta meta;

	public List<DataItem> getData(){
		return data;
	}

	public Meta getMeta(){
		return meta;
	}
}