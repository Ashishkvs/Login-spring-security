package com.imagegrafia.utility;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.imagegrafia.model.FileInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUploadUtil {

	public static FileInfo storeFile(String directoryName, MultipartFile file) {

		// check dir exists
		String filePath = "src/main/resources/static/" + directoryName;
		File directory = new File(filePath);
		if (!directory.exists()) {
			log.info("Creating New Directory" + filePath);
			directory.mkdir();

		}

		String newFileName = System.currentTimeMillis()
				+ file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);

		try {
			byte[] bytes = file.getBytes();

			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(filePath + "/" + newFileName)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FileInfo(file.getOriginalFilename(), directoryName + "/" + newFileName);
	}
}
