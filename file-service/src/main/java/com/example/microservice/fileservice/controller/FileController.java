package com.example.microservice.fileservice.controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.core.dto.BasePostResDto;
import com.example.microservice.fileservice.dto.PostFileReqDataDto;
import com.example.microservice.fileservice.model.File;
import com.example.microservice.fileservice.service.declaration.GetByIdFileService;
import com.example.microservice.fileservice.service.declaration.InsertFileService;

@RestController
@RequestMapping("files")
public class FileController {

	@Autowired
	private GetByIdFileService getByIdFileService;

	@Autowired
	private InsertFileService insertFileService;

	@GetMapping("download/{id}")
	public ResponseEntity<?> download(@PathVariable("id") String id) {
		final Optional<File> file = getByIdFileService.getById(id);
		final byte[] fileBytes = Base64.getDecoder().decode(file.get().getFile());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=attachment." + file.get().getExtensions()).body(fileBytes);
	}

	@PostMapping()
	public ResponseEntity<BasePostResDto> insert(@RequestBody PostFileReqDataDto data) {
		final BasePostResDto result = insertFileService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

}
