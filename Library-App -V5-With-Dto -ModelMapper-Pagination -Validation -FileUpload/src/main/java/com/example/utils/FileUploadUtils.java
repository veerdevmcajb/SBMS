package com.example.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {

 public static void saveFile(String uploadDir, String fileName , MultipartFile multipart)throws Exception {
	 
	 Path uploadPathobj = Paths.get(uploadDir);
	 
	try(InputStream inputStream = multipart.getInputStream())
	{
		if(!Files.exists(uploadPathobj)) {
			Files.createDirectories(uploadPathobj);
		}
		
		Path filePath = uploadPathobj.resolve(fileName);
		
		Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
	}
 
 }
}
