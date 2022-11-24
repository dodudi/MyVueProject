package com.vue.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class UploadController {
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	private String path = "c:/upload/";
	
	@PostMapping("/imageUpload")
	public String upload(@RequestParam("file") MultipartFile file) {
		try {
			String uploadPath = path;
			String originFilename = file.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			String saveFileName  = "";
			
			Calendar calendar = Calendar.getInstance();
			saveFileName += calendar.get(Calendar.YEAR);
			saveFileName += calendar.get(Calendar.MONTH);
			saveFileName += calendar.get(Calendar.DATE);
			saveFileName += calendar.get(Calendar.HOUR);
			saveFileName += calendar.get(Calendar.MINUTE);
			saveFileName += calendar.get(Calendar.SECOND);
			saveFileName += calendar.get(Calendar.MILLISECOND);
			saveFileName += extName;
			
			if(!file.isEmpty()) {
				File getFile = new File(uploadPath, saveFileName);
				file.transferTo(getFile);
				
			}
		}catch(Exception e) {
			
		}
		return "";
	}
	
	@GetMapping("/imageDownload")
	public ResponseEntity<Resource> download(String path){
		Path rpath = Paths.get(path);
		
	}
}
