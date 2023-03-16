package com.example.microservice.fileservice.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.fileservice.dao.declaration.GetByIdFileDao;
import com.example.microservice.fileservice.model.File;
import com.example.microservice.fileservice.service.declaration.GetByIdFileService;

@Service
public class GetByIdServiceImpl implements GetByIdFileService {

	@Autowired
	private GetByIdFileDao getByIdFileDao;

	@Override
	public Optional<File> getById(String id) {
		return getByIdFileDao.getById(id);
	}

}
