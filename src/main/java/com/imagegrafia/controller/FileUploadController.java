package com.imagegrafia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imagegrafia.model.FileInfo;
import com.imagegrafia.utility.FileUploadUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/upload")

@CrossOrigin(origins = "*", maxAge = 3600 , allowedHeaders="*")
@Slf4j
public class FileUploadController {
	@PostMapping
	public ResponseEntity<List<FileInfo>> fileUpload(@RequestParam("files") MultipartFile[] files) throws IOException {
		List<FileInfo> listFileInfo =new ArrayList<>();
		for (MultipartFile file : files) {
			FileInfo storedFile = FileUploadUtil.storeFile("kaju", file);
			log.info("Uploaded file -> {}",storedFile);
			listFileInfo.add(storedFile);
		}
		return ResponseEntity.ok(listFileInfo);
	}

}
