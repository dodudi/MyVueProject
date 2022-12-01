package com.vue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.dto.MemberDTO;
import com.vue.dto.MockMemberDTO;

@Mapper
public interface MemberMapper {
	public int getCount();
	public int addMember(MemberDTO memberDTO);
	public MemberDTO getMember(MemberDTO memberDTO);
	
	public int addMockMember(MockMemberDTO memberMock);
}
