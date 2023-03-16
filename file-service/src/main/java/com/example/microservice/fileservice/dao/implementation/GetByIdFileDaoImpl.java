package com.example.microservice.fileservice.dao.implementation;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.microservice.fileservice.dao.base.BaseFileDao;
import com.example.microservice.fileservice.dao.declaration.GetByIdFileDao;
import com.example.microservice.fileservice.model.File;

@Repository
public class GetByIdFileDaoImpl extends BaseFileDao implements GetByIdFileDao {

	@Override
	public Optional<File> getById(String id) {
		return repository.findById(id);
	}

}
