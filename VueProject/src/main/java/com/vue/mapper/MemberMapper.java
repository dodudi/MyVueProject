package com.vue.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vue.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	public int getCount();
	public int addMember(MemberDTO memberDTO);
	public MemberDTO getMember(MemberDTO memberDTO);
}
