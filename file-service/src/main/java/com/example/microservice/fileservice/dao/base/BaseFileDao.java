package com.example.microservice.fileservice.dao.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.microservice.core.dao.BaseEntityManager;
import com.example.microservice.fileservice.repository.FileRepository;

public class BaseFileDao extends BaseEntityManager {
	@Autowired
	public FileRepository repository;
}
