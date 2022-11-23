package com.vue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vue.dto.MemberDTO;
import com.vue.service.MemberService;

@RestController
public class MemberController {
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	
	
	@PostMapping("/memberJoin")
	public boolean memberJoin(@RequestBody MemberDTO member) {
		log.info(member.toString());
		boolean resultData = memberService.joinCheck(member);
		return resultData;
	}
	
	@PostMapping("/memberLogin")
	public String memberLogin(@RequestBody MemberDTO member) {
		String result = memberService.loginCheck(member);
		log.info(result);
		return result;
	}
}
