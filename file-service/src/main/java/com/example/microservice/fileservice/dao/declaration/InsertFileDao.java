package com.example.microservice.fileservice.dao.declaration;

import com.example.microservice.fileservice.model.File;

public interface InsertFileDao {
	File insert(File data);
}
