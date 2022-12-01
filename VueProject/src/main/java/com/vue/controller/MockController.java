package com.vue.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vue.dto.MockMemberDTO;
import com.vue.service.MemberService;
import com.vue.service.MemberServiceImpl;

@RestController
public class MockController {
	@Autowired
	private MemberServiceImpl service;
	private static final Logger log = LoggerFactory.getLogger(MockController.class);
	@PostMapping("/addUserMock")
	public int addUserMock(@RequestBody List<MockMemberDTO> mockMember) {
		log.info(mockMember + "");
		int result = service.addMockMember(mockMember);
		return 1;
	}
} 
