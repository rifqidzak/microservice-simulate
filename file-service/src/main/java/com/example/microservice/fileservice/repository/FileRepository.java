package com.example.microservice.fileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservice.fileservice.model.File;

public interface FileRepository extends JpaRepository<File, String> {

}
