package com.vue.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class UploadController {
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	private String path = "c:/upload/";
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		try {
			String uploadPath = path;
			String originFilename = file.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			String saveFileName  = "";
			String fullUrl = "";
			Calendar calendar = Calendar.getInstance();
			saveFileName += calendar.get(Calendar.YEAR);
			saveFileName += calendar.get(Calendar.MONTH);
			saveFileName += calendar.get(Calendar.DATE);
			saveFileName += calendar.get(Calendar.HOUR);
			saveFileName += calendar.get(Calendar.MINUTE);
			saveFileName += calendar.get(Calendar.SECOND);
			saveFileName += calendar.get(Calendar.MILLISECOND);
			saveFileName += extName;
			
			log.info(uploadPath);
			log.info(originFilename);
			log.info(extName);
			log.info(saveFileName);
			fullUrl = uploadPath + saveFileName;
			if(!file.isEmpty()) {
				File getFile = new File(uploadPath, saveFileName);
				file.transferTo(getFile);
			}
			return fullUrl;
		}catch(Exception e) {
			
		}
		return "";
	}
	
	@GetMapping("/download/{c}/{upload}/{fileName}")
	public ResponseEntity<Object> download(
			@PathVariable(name = "fileName") String fileName,
			@PathVariable(name = "upload") String upload,
			@PathVariable(name = "c") String c
			) {
		String path = c+ "/" +  upload + "/"+ fileName;
		log.info(path);
		try {
			Path filePath = Paths.get(path);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기
			
			File file = new File(path);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
			
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
}
