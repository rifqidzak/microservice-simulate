package com.example.microservice.fileservice.dao.implementation;

import org.springframework.stereotype.Repository;

import com.example.microservice.fileservice.dao.base.BaseFileDao;
import com.example.microservice.fileservice.dao.declaration.InsertFileDao;
import com.example.microservice.fileservice.model.File;

@Repository
public class InsertFileDaoImpl extends BaseFileDao implements InsertFileDao {

	@Override
	public File insert(File data) {
		return repository.save(data);
	}

}
