package com.example.microservice.fileservice.dao.declaration;

import java.util.Optional;

import com.example.microservice.fileservice.model.File;

public interface GetByIdFileDao {
	Optional<File> getById(String id);
}
