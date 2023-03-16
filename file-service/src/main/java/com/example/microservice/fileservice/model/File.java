package com.example.microservice.fileservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.microservice.core.model.BaseModel;

@Entity
@Table(name = "file")
public class File extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "extensions")
	private String extensions;

	@Column(name = "file", nullable = false, columnDefinition="text")
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
