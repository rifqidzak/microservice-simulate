package com.example.microservice.fileservice.service.declaration;

import com.example.microservice.core.dto.BasePostResDto;
import com.example.microservice.fileservice.dto.PostFileReqDataDto;

public interface InsertFileService {
	BasePostResDto insert(PostFileReqDataDto data);
}
