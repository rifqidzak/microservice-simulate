package com.example.microservice.core.dto;

public class BaseGetResData<T> {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
