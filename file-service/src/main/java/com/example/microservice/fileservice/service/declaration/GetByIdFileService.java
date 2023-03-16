package com.example.microservice.fileservice.service.declaration;

import java.util.Optional;

import com.example.microservice.fileservice.model.File;

public interface GetByIdFileService {
	Optional<File> getById(String id);
}
