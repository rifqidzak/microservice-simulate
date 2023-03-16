package com.example.microservice.fileservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.core.dto.BasePostResDto;
import com.example.microservice.core.service.BaseService;
import com.example.microservice.fileservice.dao.declaration.InsertFileDao;
import com.example.microservice.fileservice.dto.PostFileReqDataDto;
import com.example.microservice.fileservice.model.File;
import com.example.microservice.fileservice.service.declaration.InsertFileService;

@Service
public class InsertFileServiceImpl extends BaseService implements InsertFileService {

	@Autowired
	private InsertFileDao insertFileDao;

	@Override
	public BasePostResDto insert(PostFileReqDataDto data) {
		File fileInsert = new File();
		fileInsert.setFile(data.getFile());
		fileInsert.setExtensions(data.getExtensions());
		fileInsert = insertFileDao.insert(fileInsert);
		
		return setToPostRes(fileInsert.getId());
	}

}
