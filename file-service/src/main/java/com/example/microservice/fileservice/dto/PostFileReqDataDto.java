package com.example.microservice.fileservice.dto;

public class PostFileReqDataDto {
	private String extensions;
	private String file;

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
