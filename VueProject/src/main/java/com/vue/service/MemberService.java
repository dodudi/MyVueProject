package com.vue.service;


import org.springframework.stereotype.Service;

import com.vue.dto.MemberDTO;

@Service
public interface MemberService {
	public boolean joinCheck(MemberDTO member);
	public String loginCheck(MemberDTO member);
}
