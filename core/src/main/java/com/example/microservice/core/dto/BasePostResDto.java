package com.example.microservice.core.dto;

public class BasePostResDto {
	private BasePostResDataDto data = new BasePostResDataDto();
	private String message;
	
	public BasePostResDataDto getData() {
		return data;
	}
	public void setData(BasePostResDataDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
