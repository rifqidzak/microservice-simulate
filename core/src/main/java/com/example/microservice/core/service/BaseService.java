package com.example.microservice.core.service;

import com.example.microservice.core.dto.BaseGetCountData;
import com.example.microservice.core.dto.BaseGetResData;
import com.example.microservice.core.dto.BasePostResDataDto;
import com.example.microservice.core.dto.BasePostResDto;
import com.example.microservice.core.dto.BasePutResDataDto;
import com.example.microservice.core.dto.BasePutResDto;
import com.example.microservice.core.dto.BaseResDeleteData;

public class BaseService {
	public Integer startQueryForPaging(Integer page) {
		if (page != null) {
			Integer start = page - 1;
			return start;
		} else {
			return null;
		}
	}

	protected BaseGetResData<BaseGetCountData> setToCount(Long data) {
		BaseGetResData<BaseGetCountData> dto = new BaseGetResData<>();
		BaseGetCountData countData = new BaseGetCountData();
		countData.setCountData(data);
		dto.setData(countData);
		return dto;
	}

	protected BasePostResDto setToPostRes(String id) {
		BasePostResDataDto postId = new BasePostResDataDto();
		BasePostResDto postResDto = new BasePostResDto();
		postId.setId(id);
		postResDto.setData(postId);
		postResDto.setMessage("Data Created!");
		return postResDto;
	}

	protected BasePutResDto setToPutResDto(Integer version, String id) {
		BasePutResDataDto putRes = new BasePutResDataDto();
		BasePutResDto putResDto = new BasePutResDto();
		putRes.setId(id);
		putRes.setVersion(version);
		putResDto.setData(putRes);
		return putResDto;
	}

	protected BaseResDeleteData setToBaseResDeleteData(Boolean succeed) {
		BaseResDeleteData deleteData = new BaseResDeleteData();
		if (succeed) {
			deleteData.setMessage("Data deleted successfully!");
			return deleteData;
		} else {
			deleteData.setMessage("Data deleted fail!");
			return deleteData;
		}
	}
}
