package com.vue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.dto.MemberDTO;
import com.vue.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public String joinCheck(MemberDTO member) {
		MemberDTO getMember = memberMapper.getMember(member);
		String resultData = "";
		if(getMember == null) {
			resultData = "success";
		}else {
			resultData = "fail";
		}
		return resultData;
	}

	@Override
	public int join(MemberDTO member) {
		return memberMapper.addMember(member);
	}

	@Override
	public String loginCheck(MemberDTO member) {
		MemberDTO getMember = memberMapper.getMember(member);
		String resultData = "";
		if(getMember == null) {
			resultData = "id";
		}
		
		if(resultData == "" && !getMember.getMEMBER_PASS().equals(member.getMEMBER_PASS())) {
			resultData = "pass";
		}
		return resultData;
	}
}