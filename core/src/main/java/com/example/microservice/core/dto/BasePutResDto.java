package com.example.microservice.core.dto;

public class BasePutResDto {
	
	private BasePutResDataDto data = new BasePutResDataDto();
	private String message;
	public BasePutResDataDto getData() {
		return data;
	}
	public void setData(BasePutResDataDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
