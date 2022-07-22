package com.masoudjafari.taskjava.data.model;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("total_items_count")
	private int totalItemsCount;

	@SerializedName("remaining_items_count")
	private int remainingItemsCount;

	@SerializedName("operation_result")
	private String operationResult;

	@SerializedName("next_url")
	private String nextUrl;

	@SerializedName("display_message")
	private String displayMessage;

	@SerializedName("operation_result_code")
	private int operationResultCode;

	@SerializedName("server_date_time")
	private String serverDateTime;

	public int getTotalItemsCount(){
		return totalItemsCount;
	}

	public int getRemainingItemsCount(){
		return remainingItemsCount;
	}

	public String getOperationResult(){
		return operationResult;
	}

	public String getNextUrl(){
		return nextUrl;
	}

	public String getDisplayMessage(){
		return displayMessage;
	}

	public int getOperationResultCode(){
		return operationResultCode;
	}

	public String getServerDateTime(){
		return serverDateTime;
	}
}