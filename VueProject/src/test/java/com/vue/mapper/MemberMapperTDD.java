package com.vue.mapper;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vue.dto.MemberDTO;

@SpringBootTest
public class MemberMapperTDD {
	private static final Logger log = LoggerFactory.getLogger(MemberMapperTDD.class);
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void getCount() {
		log.info(""+memberMapper.getCount());
	}
	
	
	private static final String MEMBER_ID = "user02";
	private static final String MEMBER_PASS = "1234";
	private static final String MEMBER_NAME = "김민수";
	@Test
	public void addMember() {
		MemberDTO member = new MemberDTO();
		member.setMemberId(MEMBER_ID);
		member.setMemberPass(MEMBER_PASS);
		member.setMemberName(MEMBER_NAME);
		memberMapper.addMember(member);
	}
	
	@Test
	public void getMember() {
		MemberDTO member = new MemberDTO();
		member.setMemberId(MEMBER_ID);
		member.setMemberPass(MEMBER_PASS);
		member.setMemberName(MEMBER_NAME);
		MemberDTO getMember = memberMapper.getMember(member);
		log.info(getMember + "");
	}
}
