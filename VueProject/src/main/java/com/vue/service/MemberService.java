package com.vue.service;


import org.springframework.stereotype.Service;

import com.vue.dto.MemberDTO;

@Service
public interface MemberService {
	public String joinCheck(MemberDTO member);
	public int join(MemberDTO member);
	public String loginCheck(MemberDTO member);
}
